private Runnable mRepeatIncrementRunnable = new Runnable() {
    @Override
    public void run() {
        if (mShouldIncrement) {
            increment();
            if (mListener != null) {
                mListener.onTick(mCurrentValue);
            }
        } else {
            mHandler.removeCallbacks(this);
            return;
        }
        mHandler.postDelayed(this, mTickIntervalMs);
    }
};

public void start() {
    mShouldIncrement = true;
    mHandler.post(mRepeatIncrementRunnable);
}