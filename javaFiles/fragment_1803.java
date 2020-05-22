private final Runnable mRunnable = new Runnable() {
    @Override
    public void run() {
        if (mStarted) {
            long seconds = (System.currentTimeMillis() - t) / 1000;
            statusBar.setText(String.format("%02d:%02d", seconds / 60, seconds % 60));
            handler.postDelayed(runnable, 1000L);
        }
    }

};

private Hanlder mHandler;
private boolean mStarted;

@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    mHandler = new Handler();
}

@Override
protected void onStart() {
    super.onStart();
    mStarted = true;
    mHandler.postDealyed(runnable, 1000L);
}

@Override
protected void onStop() {
    super.onStop();
    mStarted = false;
    mHandler.removeCallbacks(mRunnable);
}