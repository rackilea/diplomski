public class RealmAuthenticationProvider implements AuthenticationProvider {

    private RUPAuthenticator rupAuthenticator;

    public RealmAuthenticationProvider(RUPAuthenticator rupAuthenticator) {
        this.rupAuthenticator = rupAuthenticator;
    }

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {

        Object principal = authentication.getPrincipal();
        Object credentials = authentication.getCredentials();
        Object realm = authentication.getDetails();
        if (rupAuthenticator.authenticate(principal, credentials, realm)) {
            List<GrantedAuthority> grantedAuths = new ArrayList<GrantedAuthority>();
            grantedAuths.add(new SimpleGrantedAuthority("ROLE_USER")); //use any GrantedAuthorities you need
            return new RealmAuthenticationToken(principal, credentials, realm, grantedAuths);
        };
        return null;
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return RealmAuthenticationToken.class.isAssignableFrom(authentication);
    }
}