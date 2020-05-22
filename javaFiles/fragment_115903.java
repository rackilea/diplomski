@Override
public AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
    SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
    Set<String> permissionsSet = //logic to get the permissions here

    info.addStringPermissions(permissionsSet);

    SecurityUtils.getSubject().getSession().setAttribute("permissions", permissionsSet);
    return info;
}