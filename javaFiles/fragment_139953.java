http.requestMatchers() //1
        .antMatchers("/login", "/oauth/authorize") //2
        .and() //3
        .authorizeRequests() //4
        .anyRequest() //5
        .authenticated() //6;