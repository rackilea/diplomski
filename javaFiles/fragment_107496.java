@Inject
UserHolder userHolder;

@Subscribe public void onLoginCompleted(UserResultEvent event) {

    Log.e(" Finding ", userHolder.getUser().getAuthTokenWebService());

    User user       =   event.user;
    userHolder.setUser(user);