package com.test.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toast.makeText( this,"The developer machine is " + BuildConfig.DEVELOPER_MACHINE_IP, Toast.LENGTH_LONG).show();
    }
}