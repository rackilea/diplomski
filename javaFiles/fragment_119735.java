package com.example.stackoverflow;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.Toast;
import android.app.Activity;
import android.graphics.drawable.Drawable;


public class Game extends Activity {

private ImageView firstClicked = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.game);

            GridView gridview = (GridView) findViewById(R.id.gridview);
        gridview.setAdapter(new ImageAdapter(this));

        gridview.setOnItemClickListener(new OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View v, int position, long id) {
                Toast.makeText(Game.this, "" + position, Toast.LENGTH_SHORT).show();
                if(firstClicked != null){
                    ImageView v2 = (ImageView)v;
                    Drawable d2 = v2.getDrawable();
                    Drawable d1 = firstClicked.getDrawable();
                    v2.setImageDrawable(d1);
                    firstClicked.setImageDrawable(d2);
                    firstClicked = null;
                }
                else {
                    firstClicked = (ImageView)v;
                }
            }

        });
    }
}