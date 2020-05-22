@Bean
public MyDaoAuthenticationProvider myAuthProvider() {
    MyDaoAuthenticationProvider provider = new MyDaoAuthenticationProvider();
    provider.setPasswordEncoder(passwordEncoder());
    provider.setUserDetailsService(securityService);
    return provider;
}