@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_count_down);

    // Comment-out this line.
    // c = new Clepsydra(this);

    // Add this line instead
    c = findViewById(R.id.view_clepsydra);

    h = new Handler();
    pi =  PendingIntent.getActivity(this, 1, new Intent(this, EndOfCountDownActivity.class), PendingIntent.FLAG_UPDATE_CURRENT);
    am = (AlarmManager) this.getSystemService(Context.ALARM_SERVICE);
    refreshRunnable = new Runnable() {
        @Override
        public void run() {
            if (isActive){
                long val = countdown - (SystemClock.elapsedRealtime() - startTime);
                TextView cd = findViewById(R.id.textView4);
                cd.setText(String.format("%02d:%02d:%02d",
                        TimeUnit.MILLISECONDS.toHours(val),
                        TimeUnit.MILLISECONDS.toMinutes(val) -
                                TimeUnit.HOURS.toMinutes(TimeUnit.MILLISECONDS.toHours(val)),
                        TimeUnit.MILLISECONDS.toSeconds(val) -
                                TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes(val))));
                c.setFillRatio((double)val/countdown);
                // Comment-out this line as well.
                // c.invalidate();
                h.postDelayed(refreshRunnable, 500);
            }
        }
    };
}