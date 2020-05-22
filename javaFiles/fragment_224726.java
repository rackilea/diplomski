package com.msp.exampleapplication;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

public class PrimaryClass extends AppCompatActivity {
TextView placeholder;

@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.primary_layout);
    placeholder=(TextView) findViewById(R.id.placeholder);

    placeholder.setText(getIntent().getStringExtra("message"));

}
}