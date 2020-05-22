@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
@Order(SecurityProperties.ACCESS_OVERRIDE_ORDER)
public class SecurityConfig extends WebSecurityConfigurerAdapter {
@Autowired
private ClientDetailsService clientDetailsService;

/*@Autowired
private SecurityHandler securityHandler;

@Autowired
private UserSecurityService userSecurityService;
*/

private static final String[] PUBLIC_MATCHERS = {
        "/css/**",
        "/js/**",
        "/images/**",
        "/",
        "**/",
        "/newUser",
        "/forgetPassword",
        "/login",
        "**/uploads/**",
        "/assets/**",
        "/api/updateCardStatus",
        "/fonts/**",
        "/users"
};

   /* @Override
    protected void configure(HttpSecurity http) throws Exception {

        http
                .authorizeRequests()

                *//*    antMatchers("/**").*//*
                .antMatchers(PUBLIC_MATCHERS).
                permitAll().anyRequest().authenticated();

        http
                .authorizeRequests()
                .antMatchers("/admin").hasAnyRole("ROLE_ADMIN").and()
                .formLogin().loginPage("/login").permitAll().failureUrl("/login?error")
                .successHandler(securityHandler)
                .and()
                .logout().logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
                .logoutSuccessUrl("/?logout").deleteCookies("remember-me").permitAll()
                .and()
                .rememberMe();
    }*/

@Override
protected void configure(HttpSecurity http) throws Exception {
    http
            .csrf().disable()
            .anonymous().disable()
            .authorizeRequests()
            .antMatchers("/api-docs/**").permitAll().anyRequest().authenticated();
}



@Override
public void configure(WebSecurity web) throws  Exception{
    web.ignoring()
            .antMatchers("/api/updateCardStatus","*/uploads/***","/api/getUsersDetail","/api/getStudentDetails","/api/getAccountLoad","/api/issueDirectives","/api/changePassword","/api/cardActivation","/api/CustomerAccountCardDetails","/api/accountLoad","/api/updateConsumersProfile","/api/verifyCvv"
                    ,"/api/updatePrepaidCardStatus","/api/getStatementData");
}

@Override
@Bean
public AuthenticationManager authenticationManagerBean() throws Exception {
    return super.authenticationManagerBean();
}

@Autowired
public void globalUserDetails(AuthenticationManagerBuilder auth) throws Exception {
    auth.inMemoryAuthentication()
            .withUser("admin")
            .password("pass")
            .roles("ADMIN", "USER").and()
            .withUser("appuser")
            .password("pass123").roles("USER");
}

/*@Autowired
public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
    auth.userDetailsService(userSecurityService).passwordEncoder(SecurityUtils.passwordEncoder());
}*/


@Bean
public PasswordEncoder encoder(){
    return NoOpPasswordEncoder.getInstance();
}

@Bean
public FilterRegistrationBean corsFilter() {
    UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
    CorsConfiguration config = new CorsConfiguration();
    config.setAllowCredentials(true);
    config.addAllowedOrigin("*");
    config.addAllowedHeader("*");
    config.addAllowedMethod("*");
    source.registerCorsConfiguration("/**", config);
    FilterRegistrationBean bean = new FilterRegistrationBean(new CorsFilter(source));
    bean.setOrder(0);
    return bean;
}

@Bean
@Autowired
public TokenStoreUserApprovalHandler userApprovalHandler(TokenStore tokenStore) {
    TokenStoreUserApprovalHandler handler = new TokenStoreUserApprovalHandler();
    handler.setTokenStore(tokenStore);
    handler.setRequestFactory(new DefaultOAuth2RequestFactory(clientDetailsService));
    handler.setClientDetailsService(clientDetailsService);
    return handler;
}

@Bean
@Autowired
public ApprovalStore approvalStore(TokenStore tokenStore) throws Exception {
    TokenApprovalStore store = new TokenApprovalStore();
    store.setTokenStore(tokenStore);
    return store;
}


}