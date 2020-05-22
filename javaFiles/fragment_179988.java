public class ExampleAuthenticator implements Authenticator<BasicCredentials, ExamplePrincipal> {

    @Override
    public Optional<ExamplePrincipal> authenticate(BasicCredentials credentials) throws AuthenticationException {
        if ("peeskillet".equals(credentials.getUsername())
                && "secret".equals(credentials.getPassword())) {
            return Optional.of(new ExamplePrincipal(credentials.getUsername(), Arrays.asList("ADMIN")));
        }
        return Optional.absent();
    }
}