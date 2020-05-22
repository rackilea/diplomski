package com.example.julle.bounce;
import ...
public class MainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button btn = (Button)findViewByID(R.id.button_jump);    
        AnimatedView av = (AnimatedView)findViewByID(R.id.anm_view);
        av.setJumpButton(btn);
    }

}