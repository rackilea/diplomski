public class TestSecurityConfig extends WebSecurityConfigurerAdapter {
    @Override
    public void configure(HttpSecurity http) throws Exception {
        http.csrf().disable().authorizeRequests().anyRequest().permitAll().and().securityContext().securityContextRepository(new TestSecurityContextRepository());
    }
}