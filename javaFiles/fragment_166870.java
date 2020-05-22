public class LDAPAuthenticationProvider implements AuthenticationProvider {

    @Autowired
    private MyAuthenticationService sampleService;

    @Override
    public Authentication authenticate( Authentication authentication ) throws AuthenticationException {
        LDAPAuthorizationToken auth = (LDAPAuthorizationToken)authentication;

        String username = sampleService.verifyToken( auth.getCredentials() );
        if ( username == null ) {
            throw new LoginException( "Invalid Token" );
        }

        auth.setAuthenticated( true );

        return auth;
    }

    @Override
    public boolean supports( Class<?> authentication ) {
        if ( authentication.isAssignableFrom( LDAPAuthorizationToken.class ) ) {
            return true;
        }
        return false;
    }
}

public class OTPAuthenticationProvider implements AuthenticationProvider {

    @Autowired
    private MyAuthenticationService sampleService;

    @Override
    public Authentication authenticate( Authentication authentication ) throws AuthenticationException {
        OTPAuthorizationToken auth = (OTPAuthorizationToken)authentication;

        String error = sampleService.loginWithOTP( auth.getPrincipal(), auth.getCredentials(), auth.getOTP() );
        if ( error != null ) {
            throw new LoginException( error );
        }

        auth.setAuthenticated( true );

        return auth;
    }

    @Override
    public boolean supports( Class<?> authentication ) {
        if ( authentication.isAssignableFrom( OTPAuthorizationToken.class ) ) {
            return true;
        }
        return false;
    }
}