public static String ROLE_NAME = "ROLENAME";

@Override
protected void configure(AuthenticationManagerBuilder auth) throws Exception {

    auth.inMemoryAuthentication().passwordEncoder(new Pbkdf2PasswordEncoder("key", 10000, 128))
            .withUser("userName").password("encryptedPassword").roles(ROLE_NAME);

}

@Override
protected void configure(HttpSecurity http) throws Exception {

    http
            .httpBasic()
            .and()
            .authorizeRequests()
            .antMatchers(HttpMethod.GET, "/securedPath").hasRole(ROLE_NAME)
            .and()
            .csrf().disable()
            .formLogin().disable();
}

}