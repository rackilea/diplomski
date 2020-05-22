@Configuration
@EnableAuthorizationServer
protected static class OAuth2AuthorizationConfig extends
            AuthorizationServerConfigurerAdapter {

    @Autowired
    @Qualifier("authenticationManagerBean")
    private AuthenticationManager authenticationManager;

    @Override
    public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
            clients.inMemory()
                    .withClient("myclient")
                    .secret("myclientsecret")
                    .authorizedGrantTypes("authorization_code", "refresh_token", "password")
            ...
    }

}