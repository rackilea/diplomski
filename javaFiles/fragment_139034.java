@Bean
    public UserDetailsService userDetailsService() {
        UserDetailsService service = new JdbcDaoImpl(primaryDataSource());
        service.setUsersByUsernameQuery("select username, password , true from user where username = ? ");
        service.setAuthoritiesByUsernameQuery("select user.username , role.name " 
            + " from users_role "
            + " inner join role on role.id = users_role.role_id "
            + " inner join user on user.id = users_role.user_id " 
            + " where user.username = ?");

        return service;
    }