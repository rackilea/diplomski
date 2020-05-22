@Configuration
public class WebSecurityConfig {

    @Configuration
    @Order(1)                                                        
    public static class RestWebSecurityConfigurationAdapter extends WebSecurityConfigurerAdapter {

        @Override
        protected void configure(HttpSecurity http) throws Exception {
            http
                .authorizeRequests()
                    .antMatchers(HttpMethod.GET, "/**").authenticated()
            .and()
                .httpBasic()
            .and()
                .csrf().disable();    
        }
    }
}