@Override
protected void configure(HttpSecurity http) throws Exception {
    http.csrf().disable() // Using JWT there is no need for CSRF-protection!
            .authorizeRequests()
            .anyRequest().authenticated()
            .and()
            .exceptionHandling().accessDeniedHandler(new AccessDeniedExceptionHandler())
            .and()
            .addFilter(new JwtAuthorizationFilter(authenticationManagerBean(), sessionRepository));
}