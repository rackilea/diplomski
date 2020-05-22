http
    .authorizeRequests()
    .antMatchers("/", "*.css").permitAll()
    .antMatchers("/myendpoint").authenticated()
    .and()
    .formLogin().loginPage("/login").permitAll();