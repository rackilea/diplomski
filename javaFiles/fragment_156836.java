private final Handler mHandler = new Handler();

private final Runnable mTask = new Runnable() {
    @Override
    public void run() {
        // Do your logic.
        // Now post again.
        mHandler.postDelayed(mTask, /* choose a new delay period */);
    }
};    

public void init() {
    delay = 1000L; // 1 second.
    mHandler.postDelayed(mTask, delay);
}