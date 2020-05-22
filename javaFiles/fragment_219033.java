@Configuration
@Order(1)
 public static class ApiWebSecurityConfigurationAdapter extends WebSecurityConfigurerAdapter {
    protected void configure(HttpSecurity http) throws Exception {
// Build the request matcher for CSFR protection
        RequestMatcher csrfRequestMatcher = new RequestMatcher() {

            // Disable CSFR protection on the following urls:
            private AntPathRequestMatcher[] requestMatchers = { new AntPathRequestMatcher("/api/endpoint") };

            @Override
            public boolean matches(HttpServletRequest request) {

                if (request.getMethod().matches("^GET$"))
                    return false;
                for (AntPathRequestMatcher rm : requestMatchers) {
                    if (rm.matches(request)) {
                        return false;
                    }
                }
                return true;
            } // method matches
        };

        http.antMatcher("/api/endpoint").authorizeRequests().anyRequest().hasRole("ADMIN").and().httpBasic().and()
                .csrf().requireCsrfProtectionMatcher(csrfRequestMatcher);
    }
}