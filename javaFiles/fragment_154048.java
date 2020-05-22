@Override
        public void configure(HttpSecurity http) throws Exception {
            // @formatter:off
        http.authorizeRequests().antMatchers("/oauth/authorize").authenticated()
                .and()
                .authorizeRequests().anyRequest().permitAll()
                .and()
                .formLogin().loginPage("/login").permitAll()
                .and()
                .csrf().disable();
        }