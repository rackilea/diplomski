protected void configure(HttpSecurity http) throws Exception {
  http
      .authorizeRequests()                                                          1
          .antMatchers("/resources/**", "/signup", "/about").permitAll()            2
          .antMatchers("/admin/**").hasRole("ADMIN")                                3
          .antMatchers("/db/**").access("hasRole('ADMIN') and hasRole('DBA')")      4
          .anyRequest().authenticated()                                             5
          .and()
      // ...
      .formLogin();
}