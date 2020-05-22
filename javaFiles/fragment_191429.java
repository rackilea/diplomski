@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(HttpSecurity http) {
        // ...

        http.addFilterAfter(new XGroupFilter(), BearerTokenAuthenticationFilter.class);
    }
}