@Configuration
@EnableOAuth2Client
public class RestClientConfig {

    @Value("${http.client.maxPoolSize}")
    private Integer maxPoolSize;

    @Value("${oauth2.resourceId}")
    private String resourceId;

    @Value("${oauth2.clientId}")
    private String clientId;

    @Value("${oauth2.clientSecret}")
    private String clientSecret;

    @Value("${oauth2.accessTokenUri}")
    private String accessTokenUri;


    @Autowired
    private OAuth2ClientContext oauth2ClientContext;


    @Bean
    public ClientHttpRequestFactory httpRequestFactory() {
        return new HttpComponentsClientHttpRequestFactory(httpClient());
    }

    @Bean
    public HttpClient httpClient() {
        PoolingHttpClientConnectionManager connectionManager = new PoolingHttpClientConnectionManager();
        connectionManager.setMaxTotal(maxPoolSize);
        // This client is for internal connections so only one route is expected
        connectionManager.setDefaultMaxPerRoute(maxPoolSize);
        return HttpClientBuilder.create().setConnectionManager(connectionManager).build();
    } 

    @Bean
    public OAuth2ProtectedResourceDetails oauth2ProtectedResourceDetails() {
        ResourceOwnerPasswordResourceDetails details = new ResourceOwnerPasswordResourceDetails();
        details.setId(resourceId);
        details.setClientId(clientId);
        details.setClientSecret(clientSecret);
        details.setAccessTokenUri(accessTokenUri);
        return details;
    }

    @Bean
    public AccessTokenProvider accessTokenProvider() {
        ResourceOwnerPasswordAccessTokenProvider tokenProvider = new ResourceOwnerPasswordAccessTokenProvider();
        tokenProvider.setRequestFactory(httpRequestFactory());
        return new AccessTokenProviderChain(
                  Arrays.<AccessTokenProvider> asList(tokenProvider)
                );
    }

    @Bean
    public OAuth2RestTemplate restTemplate() {
        OAuth2RestTemplate template = new OAuth2RestTemplate(oauth2ProtectedResourceDetails(), oauth2ClientContext);
        template.setRequestFactory(httpRequestFactory());
        template.setAccessTokenProvider(accessTokenProvider());
        return template;
    }   
}