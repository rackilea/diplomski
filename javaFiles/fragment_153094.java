package com.example.ir_sensor;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        openMenu = findViewById(R.id.Open_menu);
        closeMenu = findViewById(R.id.Close_menu);
    }

    View openMenu;
    View closeMenu;

    public void menu() {
        if (openMenu.getVisibility() == View.VISIBLE) {
            closeMenu.setVisibility(View.GONE);
        } else if (closeMenu.getVisibility() == View.GONE){
            openMenu.setVisibility(View.VISIBLE);
        }
    }
}