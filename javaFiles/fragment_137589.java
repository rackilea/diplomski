Button bullButton;
MediaPlayer mp;

@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    bullButton = (Button) findViewById(R.id.button1); // you need the R.layout.activity_main to be loaded to make a connection to it!
    bullButton.setOnTouchListener(new View.OnTouchListener() {
        @Override
        public boolean onTouch(View view, MotionEvent motionEvent) {

            if (motionEvent.getAction() == MotionEvent.ACTION_DOWN) {
                mp = MediaPlayer.create(MainActivity.this,R.raw.bull);
                mp.start();
            }
            else if (motionEvent.getAction() == MotionEvent.ACTION_UP) {
                mp.stop();
            }

            return true;
        }
    });
}