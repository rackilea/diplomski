AESLogin_ADx {
    com.sun.security.auth.module.LdapLoginModule REQUIRED
    userProvider="ldap://192.168.0.81:389/CN=Users,DC=rdl,DC=com,DC=tw"
    authIdentity="{USERNAME}@rdl.com.tw"
    userFilter="(&(|(samAccountName={USERNAME})(userPrincipalName={USERNAME})(cn={USERNAME}))(objectClass=user))"
    useSSL=false
    debug=true;
};