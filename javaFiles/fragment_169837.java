@Configuration
@EnableWebSecurity
public class AppSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private UserService userService;

    @Override
    protected void registerAuthentication(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userService);
    }

    @Override
    public void configure(WebSecurity web) throws Exception {
        // Ignore any request that starts with "/resources/".
        web.ignoring().antMatchers("/resources/**");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeUrls().antMatchers("/", "/index", "/user/**", "/about").permitAll()
            .antMatchers("/admin/**").hasRole("ADMIN")
            .anyRequest().authenticated()
            .and().formLogin()
            .loginUrl("/login")
            .failureUrl("/login-error")
            .loginProcessingUrl("/security_check")
            .usernameParameter("j_username").passwordParameter("j_password")
            .permitAll();

        http.logout().logoutUrl("/logout");
        http.rememberMe().rememberMeServices(rememberMeServices()).key("password");
    }

    @Bean
    public RememberMeServices rememberMeServices() {
        TokenBasedRememberMeServices rememberMeServices = new TokenBasedRememberMeServices("password", userService);
        rememberMeServices.setCookieName("cookieName");
        rememberMeServices.setParameter("rememberMe");
        return rememberMeServices;
    }

    @Configuration
    @Order(1)
    public static class ApiWebSecurityConfigurationAdapter extends WebSecurityConfigurerAdapter {

        @Override
        protected void registerAuthentication(AuthenticationManagerBuilder auth) throws Exception {
            auth.inMemoryAuthentication().withUser("api").password("pass").roles("API");
        }

        protected void configure(HttpSecurity http) throws Exception {
            http.authorizeUrls()
                .antMatchers("/api/**").hasRole("API")
                .and()
                .httpBasic();
        }
    }
}