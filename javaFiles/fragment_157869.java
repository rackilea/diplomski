public class MainActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(new MyContainer(this));

    }
}

public class MyContainer extends LinearLayout {
  public MyContainer(Context context) {
    addView(new CanvasView(context));
    ImageView iv = new ImageView(context);
    iv.setImageResource(R.drawable.wand);
    addView(iv);
  }
}