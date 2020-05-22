@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_exercise);

    // Set the image view
    exImage = (ImageView) findViewById(R.id.image_zero);
    exImage.setBackgroundResource(R.drawable.fe_0);

    // Start the timer
    timerHandler.postDelayed(timerRunnable, 0);

    // Bind the buttons
    ImageButton pp = (ImageButton) findViewById(R.id.button_play_pause_toggle);
    pp.setImageResource(R.drawable.pause);
    pp.setTag(R.drawable.pause);

    pp.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            ImageButton pp = (ImageButton) v;
            //Pause
            if ((Integer) pp.getTag() == R.drawable.pause) {
                pauseStartTime = System.currentTimeMillis();
                timerHandler.removeCallbacks(timerRunnable);
            } else { // Resume
                pauseTime += System.currentTimeMillis() - pauseStartTime;
                timerHandler.postDelayed(timerRunnable, 0);
            }
        }
    });
}