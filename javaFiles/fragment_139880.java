protected void configure(HttpSecurity http) throws Exception {
    http.authorizeRequests()
        .antMatchers("/user").access("hasRole('USER')")
        .antMatchers("/book").access("hasRole('USER')")
        .and().formLogin().loginPage("/collections/login").permitAll();
}