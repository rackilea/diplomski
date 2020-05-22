@Override
    protected void configure(HttpSecurity http) throws Exception {
        http
            .antMatcher("/test/**")
            .authorizeRequests()
                .anyRequest().authenticated()
                .and()
            .formLogin();
    }