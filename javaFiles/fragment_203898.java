http
        .formLogin()
        .loginPage("/login")
        .permitAll()
     .and()
        .logout()
        .permitAll()
     .and()
        .authorizeRequests()
        .antMatchers("/resources/**", "/signup").permitAll()
        .anyRequest().authenticated();