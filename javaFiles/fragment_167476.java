public class DummyAuthenticationManager implements AuthenticationManager {

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        // Dummy implementation. We don't check anything here.
        return authentication;
    }

}