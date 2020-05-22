/**
 * Custom Spring Security authentication provider which tries to bind to an LDAP server with
 * the passed-in credentials; of note, when used with the custom {@link LdapAuthenticatorImpl},
 * does <strong>not</strong> require an LDAP username and password for initial binding.
 * 
 * @author Jason
 */
public class LdapAuthenticationProvider implements AuthenticationProvider {

    private LdapAuthenticator authenticator;

    public Authentication authenticate(Authentication auth) throws AuthenticationException {

        // Authenticate, using the passed-in credentials.
        DirContextOperations authAdapter = authenticator.authenticate(auth);

        // Creating an LdapAuthenticationToken (rather than using the existing Authentication
        // object) allows us to add the already-created LDAP context for our app to use later.
        LdapAuthenticationToken ldapAuth = new LdapAuthenticationToken(auth, "ROLE_USER");
        InitialLdapContext ldapContext = (InitialLdapContext) authAdapter
                .getObjectAttribute("ldapContext");
        if (ldapContext != null) {
            ldapAuth.setContext(ldapContext);
        }

        return ldapAuth;
    }

    public boolean supports(Class clazz) {
        return (UsernamePasswordAuthenticationToken.class.isAssignableFrom(clazz));
    }

    public LdapAuthenticator getAuthenticator() {
        return authenticator;
    }

    public void setAuthenticator(LdapAuthenticator authenticator) {
        this.authenticator = authenticator;
    }

}