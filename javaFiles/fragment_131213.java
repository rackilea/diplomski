private static final long SPLASH_SCREEN_MS = 2500;

private long mTimeBeforeDelay;
private Handler mSplashHandler;

@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_splash_screen);
    // Create a new Handler.
    mSplashHandler = new Handler();
}

@Override
protected void onResume() {
    super.onResume();
    // The first time mTimeBeforeDelay will be 0.
    long gapTime = System.currentTimeMillis() - mTimeBeforeDelay;
    if (gapTime > SPLASH_SCREEN_MS) {
        gapTime = SPLASH_SCREEN_MS;
    }
    mSplashHandler.postDelayed(new Runnable() {
        @Override
        public void run() {
            Intent intent = new Intent(SplashScreenActivity.this, MainActivity.class);
            startActivity(intent);
            SplashScreenActivity.this.finish();
        }
    }, gapTime);
    // Save the time before the delay.
    mTimeBeforeDelay = System.currentTimeMillis();
}

@Override
protected void onPause() {
    super.onPause();
    mSplashHandler.removeCallbacksAndMessages(null);
}