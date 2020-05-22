public class MainActivity extends Activity implements OnTouchListener{
    GUI gui;
@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
        gui = new GUI(MainActivity.this);
            setContentView(gui);
    gui.setOnTouchListener(this);
}


@Override
public boolean onTouch(View v, MotionEvent event) {
    // TODO Auto-generated method stub
    Log.w("AA","Hello")
    return true;
}