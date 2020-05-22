public class LDAPAuthorizationToken extends AbstractAuthenticationToken {
    private String token;

    public LDAPAuthorizationToken( String token ) {
        super( null );
        this.token = token;
    }

    public Object getCredentials() {
        return token;
    }

    public Object getPrincipal() {
        return null;
    }
}

public class OTPAuthorizationToken extends UsernamePasswordAuthenticationToken {
    private String otp;

    public OTPAuthorizationToken( String username, String password, String otp ) {
        super( username, password );
        this.otp = otp;
    }

    public String getOTP() {
        return otp;
    }
}