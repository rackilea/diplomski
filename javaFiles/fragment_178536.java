@Bean
AuthenticationFailureHandler eventAuthenticationFailureHandler() {
    return new EventSendingAuthenticationFailureHandler();
}

@Autowired
AuthenticationFailureHandler eventAuthenticationFailureHandler;

protected void configure(HttpSecurity http) throws Exception {
    http
        .csrf().disable()
        .formLogin().failureHandler(eventAuthenticationFailureHandler)
            .and()
        .httpBasic();
}