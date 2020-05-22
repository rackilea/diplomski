@Override
protected void configure(final HttpSecurity http) throws Exception {
    http
      // ...
      .and()
      .exceptionHandling().accessDeniedHandler(accessDeniedHandler());
}