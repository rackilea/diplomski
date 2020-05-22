package com.example.random;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.Button;

public class MenuScreen extends Activity {  

@Override
public void onCreate(Bundle savedInstanceState) { 
super.onCreate(savedInstanceState);
requestWindowFeature(Window.FEATURE_NO_TITLE);
setContentView(R.layout.activity_main);

Button btn1 = (Button) findViewById (R.id.test);
Button btn2 = (Button) findViewById (R.id.test1);
Button btn3 = (Button) findViewById (R.id.test2);
Button btn4 = (Button) findViewById (R.id.verlaat_app);

btn1.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
        Log.d("DEBUG", "test");
        Intent intent = new Intent(MenuScreen.this, FotoMaker.class);
        startActivity (intent);
    }
});


btn2.setOnClickListener(new View.OnClickListener() {
    public void onClick(View view) {
        Log.d("DEBUG", "test1");
        Intent intent = new Intent(MenuScreen.this, FotoMaker.class);
        startActivity (intent);
    }
});

btn3.setOnClickListener(new View.OnClickListener() {
    public void onClick(View view) {
        Log.d("DEBUG", "test2");
        Intent intent = new Intent(MenuScreen.this, FotoMaker.class);
        startActivity (intent);
    }
});



btn4.setOnClickListener(new View.OnClickListener() {
    public void onClick(View view) {
        Log.d("DEBUG", "test3");
        MenuScreen.this.finish();
    }
});
}
}