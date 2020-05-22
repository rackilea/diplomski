http.authorizeRequests()
        .antMatchers("/ticket").access("isAuthenticated()") //or .permitAll() as explained already
        .antMatchers("**/feedback", "/ticket/**", "**/create/**")
            .access("hasAnyAuthority('MANAGER','EMPLOYEE')")
        .antMatchers("/api/**")
            .access("isAuthenticated()");