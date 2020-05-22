@Override
    public void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/mysupersecureurl/**").authenticated()
                .anyRequest().permitAll()
                .and()
                .csrf().disable();
    }