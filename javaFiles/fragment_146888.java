private Handler handler = new Handler();
private TextView textView;

private int i = 0;
private boolean flip;


@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    textView = (TextView) findViewById(R.id.hello);
    handler.post(hello_first);
}

private Runnable hello_first = new Runnable() {
    @Override
    public void run() {
            if(++i == 5) {
                handler.removeCallbacks(this);
                return;
            }

            if(flip) {
                textView.setText("Nice Work");  
            } else {
                textView.setText("Hello");
            }
            flip = !flip;

            handler.postDelayed(this, TimeUnit.SECONDS.toMillis(2));           
    }
};