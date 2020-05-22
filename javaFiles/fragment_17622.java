public class MyRealm extends AuthorizingRealm {

    private RemoteLoginClient client = ...;

    private final Map<String, Set<String>> emailToRoles = new ConcurrentHashMap<>();

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(
             AuthenticationToken token) {
        final UsernamePasswordToken userPass = (UsernamePasswordToken) token;

        final RemoteSubject authenticate = this.client.authenticate(
            userPass.getUserName(), userPass.getPassword());
        if (authenticate != null) { //assuming this means success
            this.emailToRoles.put(userPass.getUserName(), authenticate.getRoles());
            return new SimpleAuthenticationInfo(...);
        } else {
            return null;
        }
    }

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(
            PrincipalCollection principals) {
         final String username = (String) principals.getPrimaryPrincipal();
         final Set<String> roles = this.emailToRoles.get(username);
         return new SimpleAuthorizationInfo(roles);
    }

}