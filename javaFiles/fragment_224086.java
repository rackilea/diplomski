private Session.StatusCallback callback = new Session.StatusCallback() {
    @Override
    public void call(Session session, SessionState state, Exception exception) {
        onSessionStateChange(session, state, exception);
    }
};

private void onSessionStateChange(Session session, SessionState state, Exception exception) {
    if (state.isOpened()) {
        Log.d(TAG, "Logged in...");
        //fire intent
    } else if (state.isClosed()) {
        Log.d(TAG, "Logged out...");
    }
}