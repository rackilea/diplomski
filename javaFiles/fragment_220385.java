@Configuration
@EnableWebSecurity
public class SpringSecurityConfig extends WebSecurityConfigurerAdapter 
{
    @Autowired
    DataSource dataSource;

    @Autowired
    private AdminCustomAuthenticationProvider adminCustomAuthenticationProvider;

    @Autowired
    private UserCustomAuthenticationProvider userCustomAuthenticationProvider;

    @Autowired
    private CustomAuthenticationSuccessHandler customAuthenticationSuccessHandler;

    @Autowired
    private CustomAuthenticationFailureHandler customAuthenticationFailureHandler;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception
    {
        auth.authenticationProvider(adminCustomAuthenticationProvider);
        auth.authenticationProvider(userCustomAuthenticationProvider);
    }

    @Bean
    public MyAuthenticationFilter myAuthenticationFilter() throws Exception
    {
        MyAuthenticationFilter authenticationFilter = new MyAuthenticationFilter();

        authenticationFilter.setAuthenticationSuccessHandler(customAuthenticationSuccessHandler);
        authenticationFilter.setAuthenticationFailureHandler(customAuthenticationFailureHandler);
        authenticationFilter.setRequiresAuthenticationRequestMatcher(new AntPathRequestMatcher("/login", "POST"));
        authenticationFilter.setAuthenticationManager(authenticationManagerBean());

        return authenticationFilter;
    }

    @Override
    protected void configure(final HttpSecurity http) throws Exception
    {
        http
        .addFilterBefore(myAuthenticationFilter(), UsernamePasswordAuthenticationFilter.class)
        .csrf().disable()
        .authorizeRequests()
            .antMatchers("/resources/**", "/", "/login")
                .permitAll()
            .antMatchers("/config/*", "/app/admin/*")
                .hasRole("ADMIN")
            .antMatchers("/app/user/*")
                .hasAnyRole("ADMIN", "USER")
            .antMatchers("/api/**")
                .hasRole("APIUSER")
        .and().exceptionHandling()
            .accessDeniedPage("/403")
        .and().logout()
            .logoutSuccessHandler(new CustomLogoutSuccessHandler())
            .invalidateHttpSession(true);

        http.sessionManagement().maximumSessions(1).expiredUrl("/login?expired=true");
    }
}