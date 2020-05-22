@Configuration
@Profile("!PRODUCTION")
public class MockAuthenticationSecurityConfiguration extends WebSecurityConfigurerAdapter {

    private final ApplicationProperties applicationProperties;

    public MockAuthenticationSecurityConfiguration(final ApplicationProperties applicationProperties) {
        this.applicationProperties = applicationProperties;
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests().antMatchers("swagger-ui.html").permitAll();
        // All API REST endpoint can only be accessed by an authenticated user.
        http.authorizeRequests().antMatchers("/api/**").authenticated()
                // For these REST endpoint to answer HTTP code 401 in place of redirecting the user to /login.
                .and().exceptionHandling().defaultAuthenticationEntryPointFor(new Http401UnauthorizedEntryPoint(), new AntPathRequestMatcher("/api/**"))
                // On success, we want to redirect the user to a specific URL (the frontend).
                .and().formLogin().permitAll().successHandler(new SimpleUrlAuthenticationSuccessHandler(applicationProperties.getRedirectUrl()))
                .and().logout().permitAll()
        ;
        http.csrf().disable();
        http.cors();
    }

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        // Add a mocked user to be used to authenticate.
        auth.inMemoryAuthentication().withUser(User.withDefaultPasswordEncoder().username("jdoe").password("jdoe").roles("USER"));
    }

}