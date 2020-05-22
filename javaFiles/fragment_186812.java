@Override
protected void configure(HttpSecurity http) throws Exception {
    http.csrf().disable()
         .authorizeRequests().antMatchers("/createUser", "/user/**", "/user/createUser", "proxy/user/createUser")
         .permitAll()
         .formLogin().disable();

}}`