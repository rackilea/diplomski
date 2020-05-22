@Override
protected void configure(HttpSecurity http) throws Exception
{
    http
        .authorizeRequests()
        .antMatchers("/rest/protected/**")
        .authenticated()
     //Other spring sec configruation and then:
    .and()
        .cors()
        .configurationSource(corsConfigurationSource())

}