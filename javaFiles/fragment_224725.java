package com.msp.exampleapplication;

 import android.support.v7.app.AppCompatActivity;
 import android.os.Bundle;

 public class MainActivity extends AppCompatActivity {
 Button button1,button2,button3;

@Override
protected void onCreate(Bundle savedInstanceState) {
super.onCreate(savedInstanceState);
setContentView(R.layout.activity_main);
 button1=(Button)findViewById(R.id.button1);
 button2=(Button)findViewById(R.id.button2);
 button3=(Button)findViewById(R.id.button3);
 button1.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Intent intent=new Intent(MainActivity.this, PrimaryClass.class);
            intent.putExtra("message","Button 1 selected");
            startActivity(intent);
        }
    });
 button2.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Intent intent=new Intent(MainActivity.this, PrimaryClass.class);
            intent.putExtra("message","Button 2 selected");
            startActivity(intent);
        }
    });
 button3.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Intent intent=new Intent(MainActivity.this, PrimaryClass.class);
            intent.putExtra("message","Button 3 selected");
            startActivity(intent);
        }
    });
 }

  }