@Configuration
protected static class AuthenticationConfiguration extends GlobalAuthenticationConfigurerAdapter {

    @Autowired
    public CustomMongoSecurityService mongoSecurityService;

    @Override
    public void init(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(mongoSecurityService).and()
                .inMemoryAuthentication()
                .withUser("user").password("password").roles("USER").and()
                .withUser("admin").password("1234").roles("ADMIN");
    }

}