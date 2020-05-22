public void stopListeningForTimeOut(CallContext callContext) {
    mHandler.removeCallbacks(mMapRunnables.get(callContext));
    mMapRunnables.remove(callContext);
    Slog.d(TAG,
            "stopped listening for timeout for token: " + callContext + " at: "
                    + System.currentTimeMillis());
}