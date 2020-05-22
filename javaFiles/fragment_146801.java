@Configuration
@EnableWebSecurity
public class SecurityConfiguration {


    @Autowired
    private TokenLogoutSuccessHandler tokenLogoutSuccessHandler;

    @Autowired
    private AuthenticationSuccessHandler loginSuccessDBHandler; // AuthenticationSuccessHandler

    @Autowired
    private OAuth2AuthorizationServerConfig oAuth2AuthorizationServerConfig;


    @Bean
    public LoginFailureHandler authenticationFailureHandler(){
        return new LoginFailureHandler();
    }

    @Bean
    public InternalResourceViewResolver internalResourceViewResolver(){
        InternalResourceViewResolver internalResourceViewResolver = new InternalResourceViewResolver();
        internalResourceViewResolver.setPrefix("/WEB-INF/");
        internalResourceViewResolver.setSuffix(".jsp");
        return internalResourceViewResolver;
    }

    @Bean
    public MappingJackson2JsonView mappingJackson2JsonView(){
        MappingJackson2JsonView mappingJackson2JsonView = new MappingJackson2JsonView();
        mappingJackson2JsonView.setExtractValueFromSingleKeyModel(true);
        return mappingJackson2JsonView;
    }

    @Bean
    public ContentNegotiatingViewResolver viewResolvers(){

        ContentNegotiatingViewResolver contentNegotiatingViewResolver = new ContentNegotiatingViewResolver();

        List<ViewResolver> viewResolvers = new ArrayList<>();
        viewResolvers.add(internalResourceViewResolver());

        List<View>  listView = new ArrayList<>();
        listView.add(mappingJackson2JsonView());

        contentNegotiatingViewResolver.setViewResolvers(viewResolvers);
        contentNegotiatingViewResolver.setDefaultViews(listView);
        return contentNegotiatingViewResolver;

    }


    @Bean
    public OAuth2AuthenticationEntryPoint oAuth2AuthenticationEntryPointLoginForm(){
        OAuth2AuthenticationEntryPoint clientAuthenticationEntryPoint = new OAuth2AuthenticationEntryPoint();
        clientAuthenticationEntryPoint.setRealmName("xaxax/client");
        clientAuthenticationEntryPoint.setTypeName(OAuth2AccessToken.BEARER_TYPE);
        return clientAuthenticationEntryPoint;
    }


    @Bean
    public OAuth2AuthenticationEntryPoint oAuth2AuthenticationEntryPointCheckToken(){
        OAuth2AuthenticationEntryPoint clientAuthenticationEntryPoint = new OAuth2AuthenticationEntryPoint();
        clientAuthenticationEntryPoint.setRealmName("xaxax/client");
        clientAuthenticationEntryPoint.setTypeName(OAuth2AccessToken.BEARER_TYPE);
        return clientAuthenticationEntryPoint;
    }

    @Bean
    public OAuth2AuthenticationEntryPoint oAuth2AuthenticationEntryPointToken(){
        OAuth2AuthenticationEntryPoint clientAuthenticationEntryPoint = new OAuth2AuthenticationEntryPoint();
        clientAuthenticationEntryPoint.setRealmName("xaxax/client");
        clientAuthenticationEntryPoint.setTypeName(OAuth2AccessToken.BEARER_TYPE);
        return clientAuthenticationEntryPoint;
    }


    @Bean
    public ClientDetailsUserDetailsService clientDetailsUserService(){
        ClientDetailsUserDetailsService clientDetailsUserService = new ClientDetailsUserDetailsService(this.oAuth2AuthorizationServerConfig.clientDetails());
        return clientDetailsUserService;
    }


    @Bean
    public OAuth2AccessDeniedHandler oauthAccessDeniedHandler(){
        OAuth2AccessDeniedHandler oAuth2AccessDeniedHandler = new OAuth2AccessDeniedHandler();
        return oAuth2AccessDeniedHandler;
    }

    @Bean
    public ClientCredentialsTokenEndpointFilter clientCredentialsTokenEndpointFilter(){
        ClientCredentialsTokenEndpointFilter clientCredentialsTokenEndpointFilter = new ClientCredentialsTokenEndpointFilter();

        List<AuthenticationProvider>  listAuthenticationProvider = new ArrayList<>();

        listAuthenticationProvider.add(this.oAuth2AuthorizationServerConfig.authenticationProvider());

        ProviderManager providerManager = new ProviderManager(listAuthenticationProvider);

        clientCredentialsTokenEndpointFilter.setAuthenticationManager(providerManager);

        return clientCredentialsTokenEndpointFilter;
    }

    @Configuration
    @Order(10)
    public static class SecurityConfigurationCheckToken   extends WebSecurityConfigurerAdapter {

        @Autowired
        private SecurityConfiguration securityConfiguration;

        @Override
        protected void configure(HttpSecurity http) throws Exception {
            // @formatter:off
            http.antMatcher("/oauth/check_token")
                    .sessionManagement()
                    .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                    .and()
                    .anonymous()
                    .and()
                    .authorizeRequests()
                        .antMatchers("/**").permitAll()
                    .and()
                    .exceptionHandling()
                    .accessDeniedHandler(securityConfiguration.oauthAccessDeniedHandler())
                    .and()
                    .authenticationProvider(securityConfiguration.oAuth2AuthorizationServerConfig.authenticationProvider())
                    .addFilterBefore(new ApiTokenAccessFilter(securityConfiguration.oAuth2AuthorizationServerConfig.tokenServices()), AbstractPreAuthenticatedProcessingFilter.class)
                    .httpBasic()
                    .authenticationEntryPoint(securityConfiguration.oAuth2AuthenticationEntryPointCheckToken());
            // @formatter:on
        }

    }

    @Configuration
    @Order(15)
    public static class SecurityConfigurationToken   extends WebSecurityConfigurerAdapter {

        @Autowired
        private SecurityConfiguration securityConfiguration;

        @Override
        protected void configure(HttpSecurity http) throws Exception {
            // @formatter:off
            http.antMatcher("/oauth/token")
                    .sessionManagement()
                    .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                    .and()
                    .anonymous().disable()
                    .authorizeRequests()
                    .antMatchers("/oauth/token").fullyAuthenticated()
                    .and()
                    .exceptionHandling()
                    .accessDeniedHandler(securityConfiguration.oauthAccessDeniedHandler())
                    .and()
                    .authenticationProvider(securityConfiguration.oAuth2AuthorizationServerConfig.authenticationProvider())
                    .addFilterAfter(securityConfiguration.clientCredentialsTokenEndpointFilter(), BasicAuthenticationFilter.class)
                    .httpBasic()
                    .authenticationEntryPoint(securityConfiguration.oAuth2AuthenticationEntryPointToken());
            // @formatter:on
        }

    }


    @Configuration
    @Order(20)
    public static class SecurityConfigurationFrom extends WebSecurityConfigurerAdapter {

        @Autowired
        private SecurityConfiguration securityConfiguration;

        @Override
        protected void configure(HttpSecurity http) throws Exception {

           // @formatter:off
            http
                    .sessionManagement()
                        .sessionCreationPolicy(SessionCreationPolicy.ALWAYS)
                    .and()
                        .anonymous()
                    .and()
                        .authenticationProvider(securityConfiguration.oAuth2AuthorizationServerConfig.authenticationProvider())
                        .addFilterBefore(new ApiTokenAccessFilter(securityConfiguration.oAuth2AuthorizationServerConfig.tokenServices()), AbstractPreAuthenticatedProcessingFilter.class)
                        .authorizeRequests()
                            .antMatchers("/oauth/token/**").permitAll()
                            .antMatchers("/oauth/authorize/**").permitAll()
                            .antMatchers("/oauth/principal/**").hasRole("USER")
                            .antMatchers("/login.jsp").permitAll()
                    .and()
                        .exceptionHandling()
                            .accessDeniedPage("/login.jsp?authorization_error=true")
                    .and()
                        .httpBasic()
                            .authenticationEntryPoint(securityConfiguration.oAuth2AuthenticationEntryPointLoginForm())
                    .and()
                        .csrf()
                            .disable()
                        .logout()
                        .logoutUrl("/logout.do")
                        .logoutSuccessHandler(securityConfiguration.tokenLogoutSuccessHandler)
                        .logoutSuccessUrl("/login.jsp")
                    .and()
                        .formLogin()
                            .successHandler(securityConfiguration.loginSuccessDBHandler)
                            .failureHandler(securityConfiguration.authenticationFailureHandler())
                            .loginProcessingUrl("/login.do")
                            .usernameParameter("j_username")
                            .passwordParameter("j_password")
                            .failureUrl("/login.jsp?authentication_error=true")
                            .loginPage("/login.jsp")
            ;
            http.headers().frameOptions().sameOrigin();
            // @formatter:on

        }

    }


}