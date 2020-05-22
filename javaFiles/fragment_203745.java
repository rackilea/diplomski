@Order(-1)
@Configuration
public class ActuatorSecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .requestMatchers().antMatchers("/actuator/**")
                .and()
                .authorizeRequests().anyRequest().hasRole("ADMIN")
                .and()
                .httpBasic();
    }
}