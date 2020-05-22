public class GoogleAuthenticator extends Authenticator {
    private UserService userService;

    public GoogleAuthenticator(Context context) {
        super(context);
        this.userService = UserServiceFactory.getUserService();
    }

    protected User createUser(com.google.appengine.api.users.User googleUser,
                             Request request, Response response) {
        return new User(googleUser.getUserId());
    }

    protected boolean authenticate(Request request, Response response) {
        // Get current Google user
        com.google.appengine.api.users.User googleUser = userService.getCurrentUser();

        // Check if the user is authenticated
        if (googleUser!=null) {
            // Authenticated through Google authentication service

            request.getClientInfo().setUser(
                 createUser(googleUser, request, response));
            return true;
        } else {
            // Not authenticated. Redirect to the login URL
            response.redirectSeeOther(userService.createLoginURL(
                                      request.getRequestURI()));
            return false;
        }
    }
}