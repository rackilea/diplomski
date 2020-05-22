private static final long ONE_SECOND = 1000L;
private static final int MISS_LIMIT = 10;
int misses = 0;

@Override
public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);

    setContentView(R.layout.my_layout);

    final Handler handler = new Handler();
    final Runnable timer = new Runnable() {
        @Override
        public void run() {
            // user too late: increment miss counter
            if (++misses >= MISS_LIMIT) {
                //TODO miss limit reached
                finish(); // close this activity
            }
        }
    };

    final View btn1 = findViewById(R.id.button1);
    final View btn2 = findViewById(R.id.button2);
    btn1.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            // change color of other button, and start timer
            btn2.setBackgroundResource(R.color.new_color);
            handler.removeCallbacks(timer);
            handler.postDelayed(timer, ONE_SECOND);
        }
    });
    btn2.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            // user clicked button in time: restore color and stop timer
            btn2.setBackgroundResource(R.color.orig_color);
            handler.removeCallbacks(timer);
        }
    });
}