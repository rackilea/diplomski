public class MyLdapAuthenticationProvider implements AuthenticationProvider {
    private final ActiveDirectoryLdapAuthenticationProvider delegate;

    public MyLdapAuthenticationProvider(
        ActiveDirectoryLdapAuthenticationProvider delegate) {
        this.delegate = delegate;
    }

    public Authentication authenticate(Authentication authentication) {
        try {
            return this.delegate.authenticate(authentication);
        } catch (CommunicationException e) {
            throw new InternalAuthenticationServiceException(e);
        }
    }
}