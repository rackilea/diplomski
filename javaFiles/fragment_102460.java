private void onSessionStateChange(Session session, SessionState state, Exception exception) {
    if (state.isOpened()) {
        Log.i(TAG, "Logged in...");
        Intent intent = new INTENT(context, NewActivity.class);
        context.startActivity(intent);
        finish(); // back button shouldn't bring you back to this fragment
    } else if (state.isClosed()) {
        Log.i(TAG, "Logged out...");
    }
}