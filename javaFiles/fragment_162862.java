private Session.StatusCallback callback = new Session.StatusCallback() {

    @Override
    public void call(Session session, SessionState state, Exception exception) {
        onSessionStateChange(session, state, exception);
        if (session.isOpened()) {
            StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
            StrictMode.setThreadPolicy(policy);
          Log.e("user", "session established");
            Request.newMeRequest(session, new Request.GraphUserCallback() {

                @Override
                public void onCompleted(GraphUser user, Response response) {
                    if (user != null) {
                    Log.e("user", "loged user");
                        buildUserInfoDisplay(user);
                    }
                }
            }).executeAsync();
        }
        else{
          Log.e("user", "session not established");
        }
    }
    private void onSessionStateChange(Session session, SessionState state,
                                      Exception exception) {

    }
};