Handler handler;
private static int TIME_OUT = 2000; //Time to launch the another activity

@Override
protected void onCreate(Bundle savedInstanceState) {
super.onCreate(savedInstanceState);
setContentView(R.layout.activity_main2);
handler = new Handler();

handler.postDelayed(new Runnable() {
    @Override
    public void run() {
        Intent i = new Intent(Main2Activity.this, MainActivity.class); //Main2Activity is the Welcome page and MainActivity is the home page
        startActivity(i);
        finish();

    }

}, TIME_OUT);
button1 = (Button) findViewById(R.id.credit);
button1.setOnClickListener(new View.OnClickListener() {

    @Override
    public void onClick(View v) {
        flag = 1;
        handler.removeCallbacksAndMessages(null);
        Intent intent = new Intent(Main2Activity.this, credit.class);
        startActivity(intent);
    }
  });
}