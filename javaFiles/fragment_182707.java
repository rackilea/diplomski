package com.ntq.ntqapp;


import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;



public class MainActivity1 extends AppCompatActivity {
private ImageView ts1;
    private ImageView ts2;
    private ImageView ts3;
    private ImageView ts4;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main1);

        ts1 = (ImageView) findViewById(R.id.ts1);
        ts1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent myIntent = new Intent(MainActivity1.this,
                                             imageView1.class);
                startActivity(myIntent);
            }
        });

        ts2 = (ImageView) findViewById(R.id.ts2);
        ts2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent myIntent = new Intent(MainActivity1.this,
                                             imageView2.class);
                startActivity(myIntent);
            }
        });
        ts3 = (ImageView) findViewById(R.id.ts3);
        ts3.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent myIntent = new Intent(MainActivity1.this,
                                             imageView3.class);
                startActivity(myIntent);
            }
        });
        ts4 = (ImageView) findViewById(R.id.ts4);
        ts4.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent myIntent = new Intent(view.getContext(),
                                             imageView4.class);
                startActivity(myIntent);
            }
        });
    }