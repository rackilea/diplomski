@Override
protected void configure(HttpSecurity http) throws Exception {
    http
        .authorizeRequests()
            .antMatchers("/cont/**").access("hasRole('USER')")
            .and()

            .formLogin()
            .loginPage("/login")
            .defaultSuccessUrl("/login-success", true)
            .failureUrl("/failLogin.html")
            .permitAll()

            .and()
            .logout().logoutUrl("/logout-custom")
            .logoutSuccessUrl("/login")
            .addLogoutHandler(new CustomLogoutHandler())
            .permitAll()

        .and()
        .csrf()
        .disable();
}