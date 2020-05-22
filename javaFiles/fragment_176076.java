@Configuration
@EnableWebSecurity
public class WebSecurity extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        // the rest of your configuration
        http.authorizeRequests().mvcMatchers("/swagger-ui.html").hasRole("DEVELOPER")
}