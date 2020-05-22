package org.sample.example;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ScrollView;
import android.widget.TextView;

public class AutoscrollActivity extends Activity implements OnClickListener {
    /** Called when the activity is first created. */

    private Button new_joke;
    private TextView joke;
    private ScrollView scroll;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        new_joke = (Button) this.findViewById(R.id.button);
        new_joke.setOnClickListener(this);
        joke = (TextView) this.findViewById(R.id.text);
        scroll = (ScrollView) this.findViewById(R.id.scroll);
    }

    @Override
    public void onClick(View v) {
        joke.setText("Long\n\n\n\n\n\n\n\n joke \n\n\n\n\n\n\n\nlong joke joke");
        scroll.scrollTo(0, 0);
    }
}