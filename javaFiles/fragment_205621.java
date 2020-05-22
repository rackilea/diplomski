@Bean
public JdbcUserDetailsManager userDetailsManager(DataSource dataSource) {
    JdbcUserDetailsManager mgr = new JdbcUserDetailsManager();
    mgr.setDataSource(dataSource); // (1)
    return mgr;
}

@Autowired
public void configureGlobal(AuthenticationManagerBuilder auth, JdbcUserDetailsManager userDetailsManager, DataSource dataSource, PasswordEncoder enc) throws Exception {
    //set user detail service manually
    auth.userDetailsService(userDetailsManager);
    JdbcUserDetailsManagerConfigurer<AuthenticationManagerBuilder> conf =
            new JdbcUserDetailsManagerConfigurer<>(userDetailsManager);
    //apply the configurer
    auth.apply(conf);
    conf.dataSource(dataSource) // (2)
            .withDefaultSchema().passwordEncoder(enc)
            .withUser("user").password(enc.encode("password")).roles("USER").and()
            .withUser("admin").password(enc.encode("password")).roles("USER", "ADMIN");
}