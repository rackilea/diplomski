@Override
protected void configure(HttpSecurity http) throws Exception 
{
    http
        .antMatcher("/user/**").authorizeRequests()
        .antMatchers("/user/login").permitAll() //solution
        .anyRequest().hasRole("USER")
        .and()
        .formLogin()
        .loginPage("/user/login")
        .permitAll()
        .authenticationDetailsSource(authenticationDetailsSource())
        .successHandler(authenticationSuccessHandler())
        .and()
        .logout()
        .logoutUrl("/user/logout")
        .logoutSuccessUrl("/user/login?logout").permitAll()
        .logoutSuccessHandler(logoutSuccessHandler())
        .and()
        .exceptionHandling().accessDeniedHandler(accessDeniedHandler());
}