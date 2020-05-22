public class TimeOutRunnable implements Runnable {
    private static final String TAG = "TimeOutThread rupesh";

    CallContext mToken;

    // String mCallback;

    public TimeOutRunnable(CallContext callContext) {
        mToken = callContext;
        // mCallback = callbackTBD;
        // FIXME send proper callback class
    }

    @Override
    public void run() {
        Slog.d(TAG, "timeout occured for data id: " + mToken + " at: " + System.currentTimeMillis());
        mToken.onTimeOutOccurred();
    }

}