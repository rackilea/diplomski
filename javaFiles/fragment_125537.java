String appidstring="Your app id";

Session session = new Session.Builder(getBaseContext()).setApplicationId(appidstring).build();

Session.setActiveSession(session);

if (session.getState().equals(SessionState.CREATED_TOKEN_LOADED)) {
    session.openForRead(new Session.OpenRequest(this).setCallback(statusCallback));
}