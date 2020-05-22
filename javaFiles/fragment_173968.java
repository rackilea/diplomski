public class AuthenticationService implements Authenticator<BasicCredentials, User>, Authorizer<User> {

    private final UserDAO userDAO;

    public AuthenticationService(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    public Optional<User> authenticate(BasicCredentials credentials)
        throws AuthenticationException {
        User user = userDAO.getByEmail(credentials.getUsername());
        if (user != null && user.getPassword().equals(credentials.getPassword())) {
            return Optional.of(user);
        }
        return Optional.absent();
    }

    public boolean authorize(User user, String role) {
        return user.hasRole(role);
    }
}