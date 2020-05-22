@Override
protected void configure(HttpSecurity http) throws Exception {
    http.csrf().disable()
            .authorizeRequests()
            .antMatchers("/app/**").hasRole("ADMIN")
            .and()
            .formLogin()
            .loginProcessingUrl("/j_spring_security_check")
            .loginPage("/")
            .defaultSuccessUrl("/app/")
            .failureUrl("/?error=1")
            .permitAll()
            .and()
            .logout()
            .logoutSuccessUrl("/?logout");
}