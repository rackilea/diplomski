@Configuration
@EnableWebSecurity
public class SecureConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private OAuth2RestTemplate restTemplate;

    @Value("${openId.userinfo}")
    private String userInfoUri;

    @Value("${openId.clientId}")
    private String clientId;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable()
                .addFilterAfter(new OAuth2ClientContextFilter(), AbstractPreAuthenticatedProcessingFilter.class)
                .addFilterAfter(openIdConnectFilter(), OAuth2ClientContextFilter.class)
                .addFilterBefore(new UpdateSavedRequestFilter(), OAuth2Filter.class);
    }

    @Bean
    public OAuth2Filter openIdConnectFilter() {
        OAuth2Filter filter = new OAuth2Filter("/resource/**");
        filter.setRestTemplate(restTemplate);
        UserInfoTokenServices tokenServices = new UserInfoTokenServices(userInfoUri, clientId);
        tokenServices.setRestTemplate(restTemplate);
        filter.setTokenServices(tokenServices);
        return filter;
    }
}

@Configuration
@EnableOAuth2Client
public class OpenIdConnectConfig {
    @Value("${openId.userinfo}")
    private String userInfoUri;

    @Value("${openId.clientId}")
    private String clientId;

    @Value("${openId.clientSecret}")
    private String clientSecret;

    @Value("${openId.accessTokenUri}")
    private String accessTokenUri;

    @Value("${openId.userAuthorizationUri}")
    private String userAuthorizationUri;


    @Bean
    public OAuth2ProtectedResourceDetails protectedResourceDetails() {
        AuthorizationCodeResourceDetails details = new AuthorizationCodeResourceDetails();
        details.setClientId(clientId);
        details.setClientSecret(clientSecret);
        details.setAccessTokenUri(accessTokenUri);
        details.setUserAuthorizationUri(userAuthorizationUri);
        details.setScope(Arrays.asList("read"));
        details.setUseCurrentUri(true);
        return details;
    }

    @Bean
    @Scope(value = "session", proxyMode = ScopedProxyMode.TARGET_CLASS)
    public OAuth2RestTemplate restTemplate(OAuth2ClientContext clientContext) {
        OAuth2RestTemplate oAuth2RestTemplate = new OAuth2RestTemplate(protectedResourceDetails(), clientContext);
        return oAuth2RestTemplate;
    }
}