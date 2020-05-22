public void configure(HttpSecurity http) throws Exception { 
    http.logout().and()
        .antMatcher("/**").authorizeRequests() 
        .antMatchers("/index.html", "/home.html", "/", "/uaa/oauth/**").permitAll() 
        .anyRequest().authenticated().and() 
        .csrf().csrfTokenRepository(getCSRFTokenRepository()).ignoringAntMatchers("/uaa/‌​oauth/token").and() 
        .addFilterAfter(createCSRFHeaderFilter(), CsrfFilter.class); 
}