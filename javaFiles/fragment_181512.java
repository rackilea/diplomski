@Override
protected void configure(HttpSecurity http) throws Exception {
    http.authorizeRequests()
    .antMatchers("/app/v1/items/**").permitAll()
    .antMatchers("/app/v1/secure/items/**").hasAuthority("USER")
    .anyRequest().authenticated();
    http.httpBasic();
    http.csrf().disable();

}