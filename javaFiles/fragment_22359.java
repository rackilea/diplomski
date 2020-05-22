@Configuration
@EnableGlobalMethodSecurity(securedEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    public void configureAuth(AuthenticationManagerBuilder auth) throws Exception {
        auth
            .inMemoryAuthentication()
                .withUser("thomas")
                .password("password")
                .roles("USER")
            .and()
                .withUser("joe")
                .password("password")
                .roles("USER");
    }
}