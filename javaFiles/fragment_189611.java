@Override
protected void configure(HttpSecurity http) throws Exception {
    http.authorizeRequests()
            .antMatchers("/login")
            .permitAll()
            .antMatchers("/*")
            .access("hasRole('ROLE_USER')");
    http.formLogin()
            .defaultSuccessUrl("/", true)
            .loginPage("/login");
}