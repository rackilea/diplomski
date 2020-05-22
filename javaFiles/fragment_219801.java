@Configuration
public static class ApplicationSecurity extends WebSecurityConfigurerAdapter {
@Override
public void configure(HttpSecurity http) throws Exception {
            http
                 ...
                 .formLogin()
                 .loginPage("/login")
                 .and()
                   .logout().logoutUrl("/logout");
}