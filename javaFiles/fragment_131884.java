@Override
protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principles) {
    Set<String> permissions = // get the permissions for this user from the DB
    SimpleAuthorizationInfo simpleAuth = new SimpleAuthorizationInfo();
    simpleAuth.addStringPermissions(permissions);
    return simpleAuth;
}