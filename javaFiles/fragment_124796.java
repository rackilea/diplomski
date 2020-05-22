@Override
protected void configure(HttpSecurity http) throws Exception {

    http.authorizeRequests()
            .anyRequest().authenticated()
            .and()
            .formLogin()
                .loginPage( "/" )
                .loginProcessingUrl( "/j_spring_security_check" )
                .defaultSuccessUrl( "/hello" )
                .failureUrl( "/loginfailed" )
                .permitAll()
            .and()
            .logout()
                .logoutUrl( "/j_spring_security_logout" )
                .logoutSuccessUrl( "/" )
                .invalidateHttpSession( true )
            .and()
            .exceptionHandling().accessDeniedPage( "/WEB-INF/pages/403.jsp" )
            .and()
            .csrf()
            .and()
            .httpBasic();
}