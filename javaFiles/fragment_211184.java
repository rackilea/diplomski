public abstract class CountDownTimer {

    private static final String TAG = CountDownTimer.class.getSimpleName();

    private static final long TIMER_DEFAULT = 4000; //ms
    private static final long TIMER_STEP    = 1000; //ms

    private boolean mIsRunning = false;

    private long mRemainingTime = 0;
    private long mTotalTime;

    private Handler mHandler = new Handler();

/**
 * Callback fired on regular interval.
 *
 * @param millisUntilFinished The amount of time until finished.
 */
public abstract void onTick(long millisUntilFinished);

/**
 * Callback fired when the time is up.
 */
public abstract void onFinish();

public CountDownTimer(long timerStartValue) {

    if (timerStartValue >= 1) {
        mTotalTime = timerStartValue * TIMER_STEP;
        mRemainingTime = timerStartValue * TIMER_STEP;
    } else {
        mTotalTime = TIMER_DEFAULT;
        mRemainingTime = TIMER_DEFAULT;
    }
}

public CountDownTimer start() {

    mIsRunning = true;

    // Start the initial runnable task by posting through the handler
    mHandler.postDelayed(runnableCode, TIMER_STEP);
    return this;
}

public void cancel() {
    mIsRunning = false;
    mHandler.removeCallbacks(runnableCode);
}

private Runnable runnableCode = new Runnable() {
    @Override
    public void run() {

        if (mRemainingTime >= 0) {
            onTick(mRemainingTime);
        } else {
            mIsRunning = false;
            onFinish();
        }

        mRemainingTime -= TIMER_STEP;

        if (mIsRunning) {
            // Goes on
            mHandler.postDelayed(runnableCode, TIMER_STEP);
            }
        }
    };

}