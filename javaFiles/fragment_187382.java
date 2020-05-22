public class ClientIdAuthenticator implements Authenticator { 
  @Override
  public User authenticate(HttpServletRequest httpServletRequest) {
    // Lookup config from cloud datastore for requestURI
    OAuthService service = OAuthServiceFactory.getOAuthService();
    String clientId = service.getClientId(Constant.API_EMAIL_SCOPE);
    // Assert clientId contained in datastore configuration
  }
}