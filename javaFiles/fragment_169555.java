httpSecurity
    .csrf().disable()   
    .authorizeRequests().antMatchers("/**").authenticated().and().x509()
    .userDetailsService(userDetailsService).subjectPrincipalRegex("CN=(.*?),")
    .and()
    .authorizeRequests().antMatchers("/h2-console/**", "/css/**", "/image/**", "/js/**").permitAll()
    ;