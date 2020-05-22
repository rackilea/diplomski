@Override
protected void configure(HttpSecurity http) throws Exception {
    http
    .sessionManagement()
    .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
    ...
}