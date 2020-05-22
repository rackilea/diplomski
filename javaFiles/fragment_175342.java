protected void configure(HttpSecurity http) throws Exception {
    http
    .csrf().disable()
    .authorizeRequests()
        .antMatchers("/images/**").permitAll() 
        .anyRequest().authenticated()
        .antMatchers("/", "/home").access("hasRole('USER')")
        .antMatchers("/admin/**").access("hasRole('ADMIN')")
        .and().formLogin().loginPage("/login").successHandler(robotLoginSuccessHandler)
        .usernameParameter("username").passwordParameter("password")
        .and().exceptionHandling().accessDeniedPage("/Access_Denied")
        .and()
    .formLogin()
        .loginPage("/login")
        .usernameParameter("username")
        .passwordParameter("password")
        .permitAll()
        .and()
    .logout()
        .and().logout().logoutUrl("/login?logout").addLogoutHandler(robotLogoutSuccessHandler)
        .permitAll();
}