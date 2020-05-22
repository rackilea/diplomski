private static final int TIME_OUT = 1000; // [ms]
private TextView tv;

@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_splash);

    tv = (TextView) findViewById(R.id.yourTextViewId);
    tv.setText("This is the text to appear when Activity starts up");

    new Handler().postDelayed(new Runnable() {
        @Override
        public void run() {

            tv.setText("New text to be shown after TIME_OUT");

        }
    }, TIME_OUT);
}