@Override
protected void configure(HttpSecurity http) throws Exception
{
     http
    .csrf().disable()
    .authorizeRequests()
      .antMatchers(HttpMethod.OPTIONS,"/**").permitAll()//allow CORS option calls
      .antMatchers("/resources/**").permitAll()
      .anyRequest().authenticated()
    .and()
    .//add filter here

}