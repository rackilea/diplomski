public void configureGlobal( AuthenticationManagerBuilder auth) throws Exception {  
    auth
    .jdbcAuthentication()
    .dataSource(dataSource)
    .usersByUsernameQuery("select userId, password, enabled from Users where userId = ?")
    .authoritiesByUsernameQuery("select userId , role from Users where userId = ?");

}