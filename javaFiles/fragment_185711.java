public class FirstAuthenticationProvider implements AuthenticationProvider {

    @Value("${myapp.security.usefirst}") boolean useFirst;

    @Override
    public boolean supports(Class<?> authentication) {
        return useFirst && anyOtherTestingNecessary;
    }
}