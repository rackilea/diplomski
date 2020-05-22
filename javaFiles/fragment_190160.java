@Override
protected void configure(HttpSecurity http) throws Exception {
    http
            .httpBasic()
            .and()
            .authorizeRequests()
                .antMatchers("/", "/login").permitAll()
                .anyRequest().hasRole("ADMIN")
            .and()
            .csrf()
                .disable();
}