package com.example.myfirsttest;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;


public class MainActivity extends Activity{
private static final String MESSAGE_TAG = "my_message";

    @Override
    protected void onCreate(Bundle icicle) {
        super.onCreate(icicle);
        setContentView(R.layout.activity_main);
    Bundle extras = getIntent().getExtras();
    String stringMessage = extras.getString(MESSAGE_TAG);
    TextView message = (TextView) findViewById(R.id.message);
    if(stringMessage != null && !stringMessage.isEmpty()) {
       message.setText(stringMessage);
    }


    //Call the NewActivity from the MainActivity
        View view = getWindow().getDecorView().findViewById(android.R.id.content);
        view.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent startIntent = new Intent(MainActivity.this,MainActivity.class);
                startIntent.putExtra(MESSAGE_TAG, "hello second World");
                startActivity(startIntent);

            }
        }); 
    }
}