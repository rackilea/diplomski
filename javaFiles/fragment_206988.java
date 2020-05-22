@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth)
        throws Exception {
        auth
           .inMemoryAuthentication()
               .withUser("admin")
                   .password("admin")
                   .roles("ADMIN")
                   .and()
               .withUser("user")
                   .password("user")
                   .roles("USER");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
            .authorizeRequests()
                .antMatchers("/admin/**").hasRole("ADMIN")
                .antMatchers("/user/**").hasRole("USER")
                .and()
             .formLogin()
                .defaultSuccessUrl("/default")
                .loginPage("/")
                .failureUrl("/")
                .and()
            .logout()
                .logoutSuccessUrl("/")
                .and()
            // It is generally BAD to disable CSRF protection!
            .csrf().disable();
     }
}