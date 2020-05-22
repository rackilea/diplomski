@Override
protected void configure(HttpSecurity http) throws Exception {
    http.csrf().disable().authorizeRequests()
    .antMatchers("/teacher/all/**").permitAll()
    .antMatchers("/teacher/admin/**","*/create/**").hasRole("ADMIN")
    .antMatchers("/teacher/user/**").hasRole("USER")
    .and().httpBasic();
}