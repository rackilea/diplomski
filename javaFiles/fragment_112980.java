@Override
protected void configure(HttpSecurity http) throws Exception {
  http.sessionManagement().sessionCreationPolicy(STATELESS);
  http.csrf().disable();
  http.authorizeRequests()
    .antMatchers("/actuator/**").permitAll()
    .antMatchers("/**").authenticated();
  http.addFilterBefore(xyzTokenRequestHeaderAuthenticationFilter(), AbstractPreAuthenticatedProcessingFilter.class);
}

@Override
public void configure(WebSecurity web) throws Exception {
  web.ignoring().antMatchers("/actuator/**");
}