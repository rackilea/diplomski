http
    .csrf().disable()
    .authorizeRequests()
    .antMatchers("/").permitAll()
    .antMatchers("/api/v1/character/*").denyAll()
    .antMatchers("/api/v1/character/name/*").permitAll();