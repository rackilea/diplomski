http.exceptionHandling()
            .authenticationEntryPoint(MyCustomAuthenticationEntryPoint);
http
     .authorizeRequests()
     .antMatchers(HttpMethod.GET, "/filter1-urls/*").hasRole("USER")
     .antMatchers(HttpMethod.GET, "/filter2-urls/*").hasRole("SUPER_USER");
http.addFilterBefore(myCustomFilter, ChannelProcessingFilter.class);