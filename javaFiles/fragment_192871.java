package com.stackoverflow;

import android.app.Activity;
import android.os.Bundle;
import android.text.Html;
import android.view.Gravity;
import android.view.View;
import android.widget.TextSwitcher;
import android.widget.TextView;
import android.widget.ViewSwitcher.ViewFactory;

public class Test extends Activity implements ViewFactory {


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        TextSwitcher ts = (TextSwitcher) findViewById(R.id.switcher);
        ts.setFactory(this);
        ts.setText(Html.fromHtml("Test<sup>TM</sup>"));
    }

    @Override
    public View makeView() {
        TextView t = new TextView(this);
        t.setGravity(Gravity.TOP | Gravity.LEFT);
        t.setTextSize(18);
        return t;
    }