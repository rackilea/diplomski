@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter{


    @Configuration
    @Order(1)
    public static class RestApiWebSecurityConfigurationAdapter extends WebSecurityConfigurerAdapter {
        @Bean
        CorsFilter corsFilter() {
            CorsFilter filter = new CorsFilter();
            return filter;
        }

        protected void configure(HttpSecurity http) throws Exception {
            http
            .addFilterBefore(corsFilter(), SessionManagementFilter.class)
            .csrf().disable()
            .antMatcher("/rest-api/v1/**").authorizeRequests().anyRequest().hasAnyRole("APIClient")
            .and()
            .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
            .and()
            .httpBasic();
        }
    }


    @Configuration
    @Order(2)
    public static class UILoginWebSecurityConfigurerAdapter extends WebSecurityConfigurerAdapter{
        @Bean
        CorsFilter corsFilter() {
            CorsFilter filter = new CorsFilter();
            return filter;
        }

        @Override
        protected void configure(HttpSecurity http) throws Exception {
            http
            .addFilterBefore(corsFilter(), SessionManagementFilter.class)
            .and()
            .authorizeRequests()
            .antMatchers("/other/**").access("hasRole('whatever goes here')")
            // ...
            .and()
            .formLogin().loginPage("/login")
            //...
            .sessionManagement().sessionFixation().newSession().maximumSessions(1)
            .sessionRegistry(sessionRegistry());
        }    
}