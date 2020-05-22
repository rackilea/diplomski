public void configure(HttpSecurity httpSecurity) throws Exception {
    httpSecurity
        .authorizeRequests()
            .antMatchers("/home*").hasRole("USER")
            .and()
        .formLogin()
            .loginPage("/login.html")
            .permitAll();
}