package com.draw;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

public class Draw extends Activity {
     ImageView iv1;
    @Override   
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        final DrawView drawView = new DrawView(this);
        setContentView(R.layout.main);
        FrameLayout frm_layout=(FrameLayout) findViewById(R.id.main_frame);
        frm_layout.addView(drawView);
        Button btn_undo=(Button) findViewById(R.id.button1);
        btn_undo.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                drawView.onClickUndo();
            }
        });

        Button btn_redo=(Button) findViewById(R.id.button2);
        btn_redo.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                drawView.onClickRedo();
            }
        });
    }

}