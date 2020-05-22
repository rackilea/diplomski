@Configuration
@EnableWebSecurity //Very important!
@EnableGlobalMethodSecurity(securedEnabled = true)
@Profile("dev")
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Override //Very important!
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
        .antMatchers("/app/user/*").hasAnyRole("USER", "ADMIN")
        .antMatchers("/app/posts/*").hasAnyRole("USER", "ADMIN")
        .antMatchers("/app/*").permitAll()
        .and()
        .formLogin()
            .loginPage("/app/")
            .loginProcessingUrl("/login")
            .usernameParameter("username")
            .defaultSuccessUrl("/app/", true)
        .and()
        .logout()
            .logoutUrl("/app/logout")
        .and()
        .csrf()
        .and()
        .exceptionHandling()
            .accessDeniedPage("/app/forbidden");
        super.configure(http); //Very important!
    }
}