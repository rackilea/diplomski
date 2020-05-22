private Handler mHandler = new Handler();

private Runnable mRunnable = new Runnable() {
    @Override
    public void run() {
        mTextView.setText("wtv");
        mHandler.postDelayed(this, 1000);
    }
};