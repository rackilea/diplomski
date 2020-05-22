http
        .csrf().disable()
        .httpBasic().and()
        .authorizeRequests().antMatchers("/actuator/**").hasAnyRole("ACTUATOR")
        .anyRequest().authenticated()
        .anyRequest().authenticated();