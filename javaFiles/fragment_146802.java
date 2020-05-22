@Configuration
@EnableAuthorizationServer
public class OAuth2AuthorizationServerConfig extends AuthorizationServerConfigurerAdapter {

    @Autowired
    private UserDetailsService userDetailsServiceImpl;

    @Autowired
    private DataSource dataSource;


    @Bean
    public ClientDetailsService clientDetails (){
        JdbcClientDetailsService jdbcClientDetailsService = new JdbcClientDetailsService(this.dataSource);
        return jdbcClientDetailsService;
    }

    @Bean
    public TokenStore tokenStore() {
         return new JdbcTokenStore(this.dataSource);
    }


    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public AuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider daoAuthenticationProvider = new DaoAuthenticationProvider();
        daoAuthenticationProvider.setHideUserNotFoundExceptions(false);
        daoAuthenticationProvider.setUserDetailsService(this.userDetailsServiceImpl);
        daoAuthenticationProvider.setPasswordEncoder(this.passwordEncoder());
        return daoAuthenticationProvider;
    }

    @Bean
    public EmptyPasswordEncoder emptyPasswordEncoder(){
        return new EmptyPasswordEncoder();
    }


    @Bean
    public AuthenticationProvider noPasswordAuthenticationProvider() {
        DaoAuthenticationProvider daoAuthenticationProvider = new DaoAuthenticationProvider();
        daoAuthenticationProvider.setHideUserNotFoundExceptions(false);
        daoAuthenticationProvider.setUserDetailsService(this.userDetailsServiceImpl);
        daoAuthenticationProvider.setPasswordEncoder(this.emptyPasswordEncoder());
        return daoAuthenticationProvider;
    }



    @Bean
    public DefaultOAuth2RequestFactory oAuth2RequestFactory(){

        DefaultOAuth2RequestFactory oAuth2RequestFactory = new DefaultOAuth2RequestFactory(this.clientDetails());
        return oAuth2RequestFactory;

    }



    @Bean
    public UserApprovalHandler userApprovalHandler(){
        UserApprovalHandler userApprovalHandler = new UserApprovalHandler();
        userApprovalHandler.setTokenStore(this.tokenStore());
        userApprovalHandler.setRequestFactory(this.oAuth2RequestFactory());
        return userApprovalHandler;
    }


    @Bean
    public DefaultTokenServices tokenServices(){
        DefaultTokenServices tokenServices = new DefaultTokenServices();
        tokenServices.setTokenStore(this.tokenStore());
        tokenServices.setSupportRefreshToken(true);
        tokenServices.setClientDetailsService(this.clientDetails());
        return tokenServices;
    }

    @Bean
    public CheckTokenEndpoint checkTokenEndpoint(){
        CheckTokenEndpoint checkTokenEndpoint = new CheckTokenEndpoint();
        checkTokenEndpoint.setTokenServices(this.tokenServices());
        return checkTokenEndpoint;
    }



    @Override
    public void configure(ClientDetailsServiceConfigurer clients) throws Exception {

        clients.inMemory().withClient("xaxax");
        clients.withClientDetails(this.clientDetails());

    }



    @Override
    public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {

        List<AuthenticationProvider>  listAuthenticationProvider = new ArrayList<>();

        listAuthenticationProvider.add(this.authenticationProvider());

        ProviderManager providerManager = new ProviderManager(listAuthenticationProvider);

        endpoints
                .tokenStore(this.tokenStore())
                .tokenServices(tokenServices())
                .userApprovalHandler(userApprovalHandler())
                .authenticationManager(providerManager)
                .setClientDetailsService(clientDetails());

    }

    @Override
    public void configure(AuthorizationServerSecurityConfigurer oauthServer) throws Exception {

        oauthServer.tokenKeyAccess("permitAll()").checkTokenAccess("permitAll()").allowFormAuthenticationForClients();


    }


}