@Override
protected void configure(HttpSecurity http) throws Exception {
http
        .csrf().disable()
        .anonymous().disable()
        .authorizeRequests()
        .antMatchers("/api-        docs/**").permitAll().anyRequest().authenticated();
}