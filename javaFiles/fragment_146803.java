public class ApiTokenAccessFilter extends OAuth2AuthenticationProcessingFilter {

    public ApiTokenAccessFilter(ResourceServerTokenServices resourceServerTokenServices) {

        super();
        setStateless(false);
        setAuthenticationManager(oauthAuthenticationManager(resourceServerTokenServices));
    }

    private AuthenticationManager oauthAuthenticationManager(ResourceServerTokenServices tokenServices) {

        OAuth2AuthenticationManager oauthAuthenticationManager = new OAuth2AuthenticationManager();

        oauthAuthenticationManager.setResourceId("oauth2-resource");
        oauthAuthenticationManager.setTokenServices(tokenServices);
        oauthAuthenticationManager.setClientDetailsService(null);

        return oauthAuthenticationManager;
    }
}