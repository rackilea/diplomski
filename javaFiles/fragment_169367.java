package com.example.myfirstapp;

import android.app.Activity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

    public class MainActivity extends Activity implements View.OnClickListener {

        EditText mFuelCost;
        EditText mDistance;
        EditText mMilesPerGallon;

        Button mBtn1;

        TextView mResult;

        @Override
        public void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.main);

            mFuelCost = (EditText) findViewById(R.id.fuelCost);
            mDistance = (EditText) findViewById(R.id.distance);
            mMilesPerGallon = (EditText) findViewById(R.id.milesPerGallon);

            mBtn1 = (Button) findViewById(R.id.btn_1);

            mResult =(TextView) findViewById(R.id.result);

            mBtn1.setOnClickListener(this);

        }

        @Override
        public void onClick(View v) {
            float num1 = 0;
            float num2 = 0;
            float num3 = 0;

            float result = 0;

            if (TextUtils.isEmpty(mFuelCost.getText().toString())
                    || TextUtils.isEmpty(mDistance.getText().toString())
                    || TextUtils.isEmpty(mMilesPerGallon.getText().toString())) {
                return;
            }

            num1 = Float.parseFloat(mFuelCost.getText().toString());
            num2 = Float.parseFloat(mDistance.getText().toString());
            num3 = Float.parseFloat(mMilesPerGallon.getText().toString());

            switch (v.getId()) {
                case R.id.btn_1:
                    result = ((num1 * 4.5461f) * (num2 / num3)) / 100;
                    break;
                default:
                    break;
            }

            mResult.setText("£" + result);
        }
    }