@Override
protected void configure(HttpSecurity http) throws Exception {           
    ....
    String internalSecretKey = "internalSecretKey";
    http.rememberMe().rememberMeServices(rememberMeServices(internalSecretKey)).key(internalSecretKey);
}

 @Bean
 public RememberMeServices rememberMeServices(String internalSecretKey) {
     BasicRememberMeUserDetailsService rememberMeUserDetailsService = new BasicRememberMeUserDetailsService();
     InMemoryTokenRepositoryImpl rememberMeTokenRepository = new InMemoryTokenRepositoryImpl();
     PersistentTokenBasedRememberMeServices services = new PersistentTokenBasedRememberMeServices(staticKey, rememberMeUserDetailsService, rememberMeTokenRepository);
     services.setAlwaysRemember(true);
     return services;
 }