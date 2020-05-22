public class JpaRealm extends AuthorizingRealm {

    private static String REALM_NAME = "jpaRealm";

    @Inject
    private UserDao userDao;

    @Inject
    private RoleDao roleDao;

    @Inject
    private PermissionDao permissionDao;

    public JpaRealm() {
        setName(REALM_NAME); // This name must match the name in the User class's getPrincipals() method
    }

    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authToken) throws AuthenticationException {
        UsernamePasswordToken token = (UsernamePasswordToken) authToken;
        User user = userDao.getForUsername(token.getUsername());
        if (user != null) {
            return new SimpleAuthenticationInfo(user.getId(), user.getPassword(), getName());
        } else {
            return null;
        }
    }

    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        Long userId = (Long) principals.fromRealm(getName()).iterator().next();
        User user = userDao.findByKey(userId);
        if (user != null) {
            SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
            for (Role role : roleDao.getForUser(user)) {
                info.addRole(role.getDescription());
                for (Permition permition : permissionDao.getForRole(role)) {
                    info.addStringPermission(permition.getDescription());
                }
            }
            return info;
        } else {
            return null;
        }
    }

}