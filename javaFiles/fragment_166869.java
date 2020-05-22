public class LDAPAuthorizationFilter extends AbstractAuthenticationProcessingFilter {
    @Autowired
    private UserDetailsService userDetailsService;

    public LDAPAuthorizationFilter() {
        super( "/*" ); // allow any request to contain an authorization header
    }

    public Authentication attemptAuthentication( HttpServletRequest request, HttpServletResponse response ) throws AuthenticationException
    {

        if ( request.getHeader( "Authorization" ) == null ) {
            return null; // no header found, continue on to other security filters
        }

        // return a new authentication token to be processed by the authentication provider
        return new LDAPAuthorizationToken( request.getHeader( "Authorization" ) );
    }
}

public class OTPAuthorizationFilter extends AbstractAuthenticationProcessingFilter {
    @Autowired
    private UserDetailsService userDetailsService;

    public OTPAuthorizationFilter() {
        super( "/otp_login" );
    }

    public Authentication attemptAuthentication( HttpServletRequest request, HttpServletResponse response ) throws AuthenticationException
    {

        if ( request.getParameter( "username" ) == null || request.getParameter( "password" ) == null || request.getParameter( "otp" ) == null ) {
            return null;
        }

        // return a new authentication token to be processed by the authentication provider
        return new OTPAuthorizationToken( request.getParameter( "username" ), request.getParameter( "password" ), request.getParameter( "otp" ) );
    }
}