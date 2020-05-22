public class TokenServiceWSO2 implements ResourceServerTokenServices {

    @Autowired
    TokenValidatorWSO2 tokenValidatorWSO2;

    public OAuth2Authentication loadAuthentication(String accessToken) throws AuthenticationException, InvalidTokenException {

        try {
            TokenValidationResponse validationResponse = tokenValidatorWSO2.validateAccessToken(accessToken);
            OAuth2Request oAuth2Request = new OAuth2Request(null, null, null, true, validationResponse.getScope(), null, null, null,null);
            UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(validationResponse.getAuthorizedUserIdentifier(), null, null);
            OAuth2Authentication oAuth2Authentication = new OAuth2Authentication(oAuth2Request, authentication);
            return oAuth2Authentication;
        } catch (ApplicationException ex) {
            // Handle exception
        }
    }

    public OAuth2AccessToken readAccessToken(String accessToken) {
        // TODO Add implementation
    }

}