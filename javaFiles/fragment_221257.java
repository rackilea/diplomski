public class SecurityConfiguration {

    @Configuration
    @Order(1)
    public static class ApiConfigurationAdapter extends WebSecurityConfigurerAdapter {

        @Bean
        public FilterRegistrationBean customApiAuthenticationFilterRegistration() {
            FilterRegistrationBean registration = new FilterRegistrationBean(customApiAuthenticationFilter());
            registration.setEnabled(false);
            return registration;
        }

        @Bean
        public GenericFilterBean customApiAuthenticationFilter() {
            return new CustomApiAuthenticationFilter();
        }

        @Override
        protected void configure(HttpSecurity http) throws Exception {
            http.antMatcher("/api/**").addFilterAfter(customApiAuthenticationFilter(), AbstractPreAuthenticatedProcessingFilter.class)
                .authorizeRequests().anyRequest().hasRole("API").and().sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);

        }
    }

    @Configuration
    @Order(2)
    public static class WebSecurityConfiguration extends WebSecurityConfigurerAdapter {

        @Bean
        public FilterRegistrationBean customWebAuthenticationFilterRegistration() {
            FilterRegistrationBean registration = new FilterRegistrationBean(customWebAuthenticationFilter());
            registration.setEnabled(false);
            return registration;
        }

        @Bean
        public GenericFilterBean customWebAuthenticationFilter() {
            return new CustomWebAuthenticationFilter();
        }

        @Override
        protected void configure(HttpSecurity http) throws Exception {
            http.antMatcher("/").addFilterAfter(customWebAuthenticationFilter(), AbstractPreAuthenticatedProcessingFilter.class)
                .authorizeRequests().antMatchers("/").hasRole("USER");
        }
    }
}