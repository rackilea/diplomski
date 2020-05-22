public void startListeningForTimeOut(CallContext callContext) {
    TimeOutRunnable timeOutRunnable = new TimeOutRunnable(callContext);
    mMapRunnables.put(callContext, timeOutRunnable);
    mHandler.postDelayed(timeOutRunnable, TIMEOUT_DURATION);
    Slog.d(TAG,
            "started listening for timeout for token: " + callContext + " at: "
                    + System.currentTimeMillis());
}