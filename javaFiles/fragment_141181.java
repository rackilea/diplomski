@Override
protected void configure(HttpSecurity http) throws Exception
{
    http.authorizeRequests()
            .antMatchers("/admin/**").access("hasRole('ADMIN')")
            .antMatchers("/**").permitAll()
            .anyRequest().authenticated()
            .and()
            .formLogin();
}