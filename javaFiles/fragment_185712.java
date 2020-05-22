public class SecondAuthenticationProvider implements AuthenticationProvider {

    @Value("${myapp.security.usefirst}") boolean useFirst;

    @Override
    public Authentication authenticate(Authentication authentication) {
        if ( useFirst ) {
            return null; // abstain
        }

        // ... rest of authentication strategy
    }