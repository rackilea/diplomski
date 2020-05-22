public class ToolbarAnimator {
    private final static String TAG = ToolbarAnimator.class.getSimpleName();
    private final int ALPHA_MAX = 255;//just look at the documentation
    private final int NUMBER_OF_TICK = 255;//can go from 1 to 255, it's the number of tick
    private final int ALPHA_PER_TICK = ALPHA_MAX / NUMBER_OF_TICK;//alpha we'll remove/add on every tick
    private long DELAY = 1000;//amount of time in milliseconds before animation execution.
    private final AppCompatActivity mActivity;

    /*
    ** Private field
     */
    private ActionBar mActionBar;
    private Timer mTimer;
    private int mCurrentAlpha;
    private int mActionBarBackgroundColor;

    /*
    ** Constructor
     */
    public ToolbarAnimator(@NonNull AppCompatActivity activity, @NonNull final ActionBar actionBar, final int actionBarBackgroundColor) {
        mActivity = activity;
        mActionBar = actionBar;
        mTimer = new Timer();
        mCurrentAlpha = 0;
        mActionBarBackgroundColor = actionBarBackgroundColor;
    }

    /*
    ** Public method
     */
    public void start(final long duration) {
        final long period = duration / NUMBER_OF_TICK;//time beetwen 2 run() call

        Log.d(TAG, "start");
        Log.d(TAG, "delay = " + DELAY);
        Log.d(TAG, "period = " + period);
        Log.d(TAG, "duration = " + duration);
        Log.d(TAG, "alphaPerTick = " + ALPHA_PER_TICK);

        //init a timer which will updateActionBarColor on every each period
        mTimer.schedule(new TimerTask() {
            @Override
            public void run() {
                //update the actionBar
                updateActionBarColor();
            }
        }, DELAY, period);
    }

    /*
    ** Private method
     */
    private void updateActionBarColor() {
        //We have to go to the main thread for updating the interface.
        mActivity.runOnUiThread(new TimerTask() {
            @Override
            public void run() {
                //check if the animation is finish
                if (mCurrentAlpha > 255 || mCurrentAlpha < 0) {
                    Log.d(TAG, "cancel timer");
                    mTimer.cancel();
                    mTimer.purge();
                    return;
                }
                //create the new backgroundColorDrawable
                final Drawable backgroundDrawable = new ColorDrawable(mActionBarBackgroundColor);
                backgroundDrawable.setAlpha(mCurrentAlpha);

                //apply the new color
                mActionBar.setBackgroundDrawable(backgroundDrawable);

                //upgrade alpha
                mCurrentAlpha += ALPHA_PER_TICK;
            }
        });
    }
}