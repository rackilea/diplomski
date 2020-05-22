@Override
protected void configure(final HttpSecurity http) throws Exception {
    // @formatter:off
    http.
        authorizeRequests().
            antMatchers("/ping", "/actuator/health", "/actuator/info", "/login").permitAll().
            anyRequest().authenticated().and().
        httpBasic().and().
        // CSRF tokens for API access
        csrf().csrfTokenRepository(CookieCsrfTokenRepository.withHttpOnlyFalse());
    // @formatter:on
}