@EnableOAuth2Client
@Configuration
public class OAuthClientConfig {

    @Autowired
    AuthorizationServerConfig authorizationServerConfig;

    public OAuth2RestOperations restTemplate() {
        AccessTokenRequest atr = new DefaultAccessTokenRequest();

        return new OAuth2RestTemplate(authorizationServerConfig.getOwnerPasswordResource(), new DefaultOAuth2ClientContext(atr));
    }
}