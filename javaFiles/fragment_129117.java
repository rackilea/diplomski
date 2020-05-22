public class MainActivity extends ActionBarActivity implements SampleThread.TextViewChangeListener {
@Override
public void onTextViewChanged(Message msg)
{
    // process incoming messages here
    // i want to change the text of txt1 here
}

public static Handler mHandler;
Runnable thread = new SampleThread(this);
TextView txt1 = (TextView) findViewById(R.id.txt1);
@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    ActionBar actionBar = getSupportActionBar();
    actionBar.hide();

    //hiding status bar
    if (Build.VERSION.SDK_INT < 16) {
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
    } else {
        View decorView = getWindow().getDecorView();
        int uiOptions = View.SYSTEM_UI_FLAG_FULLSCREEN;
        decorView.setSystemUiVisibility(uiOptions);
    }
    setContentView(R.layout.activity_main);
    new Thread(thread).start();
}
}