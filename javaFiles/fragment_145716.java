@Override
protected void configure(HttpSecurity http) throws Exception {    

    http.authorizeRequests()
    .antMatchers("/admin/**").access("hasRole('ADMIN')")
    .antMatchers("/user/**").access("hasRole('ADMIN') or hasRole('USER')")
    .antMatchers("/sg/**").access("hasRole('USER')")
     .and().rememberMe().rememberMeParameter("remember-me").tokenRepository(persistentTokenRepository()).tokenValiditySeconds(86400*30) // 30 days
    .and().formLogin().successForwardUrl("/loginSuccessAjax.html").failureForwardUrl("/UnsuccessfulLoginAjax")
     .and().exceptionHandling().authenticationEntryPoint(authenticationEntryPoint);



}