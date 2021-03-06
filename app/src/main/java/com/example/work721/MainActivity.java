package com.example.work721;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    Button btn_find;
    EditText address;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn_find = findViewById(R.id.find_btn);
        address = findViewById(R.id.text_address);
        final Intent intent = new Intent();
        intent.setAction(Intent.ACTION_VIEW);

        btn_find.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String inputAddress = address.getText().toString();
                if (inputAddress.equals("")) {
                    Toast toast = Toast.makeText(getApplicationContext(), getText(R.string.empty), Toast.LENGTH_LONG);
                    toast.show();
                } else {
                    boolean temp = false;
                    for(int i = 0 ; i < inputAddress.length(); i++){
                        if(Character.isLetter(inputAddress.charAt(i))){
                            temp =true;
                            break;
                        }
                    }
                    if (temp) {
                        String geo = "geo:?q=" + inputAddress;
                        Uri uri = Uri.parse(geo);
                        intent.setData(uri);
                    } else {
                        String geo = "geo:" + inputAddress;
                        Uri uri = Uri.parse(geo);
                        intent.setData(uri);
                    }
                    startActivity(intent);
                }
            }
        });

    }
}
