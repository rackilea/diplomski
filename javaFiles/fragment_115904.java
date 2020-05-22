@Override
public AuthorizationInfo getAuthorizationInfo(PrincipalCollection principals) {
    return super.getAuthorizationInfo(principals);
}

....

yourRealm.getAuthorizationInfo(SecurityUtils.getSubject().getPrincipals()).getStringPermissions();