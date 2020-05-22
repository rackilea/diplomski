@Autowired
public void configureGlobalSecurity(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(inMemoryUserDetailsManager());
}

@Bean
public InMemoryUserDetailsManager inMemoryUserDetailsManager() {
        // load you user here
        final Properties users = new Properties();
        return new InMemoryUserDetailsManager(users);
}