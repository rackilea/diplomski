@Override
protected void configure(HttpSecurity http) throws Exception {
    CharacterEncodingFilter filter = new CharacterEncodingFilter();
    filter.setEncoding("UTF-8");
    filter.setForceEncoding(true);
    http.addFilterBefore(filter, CsrfFilter.class);
    http.csrf().disable();

  http.authorizeRequests()
    .antMatchers("/home/**").permitAll()
    .antMatchers("/adminpanel/**").access("hasRole('ADMIN')")
    .antMatchers("/cabinet").access("hasRole('USER')or hasRole('ADMIN')")
    /*removeed*///.and().formLogin().loginPage("/login").failureUrl("/login?error")
    .and().exceptionHandling().accessDeniedPage("/403");
}