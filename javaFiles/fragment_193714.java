@Autowired
public void configAuthentication(AuthenticationManagerBuilder auth) throws Exception {
    auth.jdbcAuthentication().dataSource(dataSource)
         .usersByUsernameQuery("select username, password, enabled from users where username=?")
         .authoritiesByUsernameQuery("select username, role from user_roles where username=?");
}