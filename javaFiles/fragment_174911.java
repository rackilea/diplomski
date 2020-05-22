protected List<UserDetails> loadUsersByUsername(String username) {
        return getJdbcTemplate().query(this.usersByUsernameQuery,
                new String[] { username }, new RowMapper<UserDetails>() {
                    @Override
                    public UserDetails mapRow(ResultSet rs, int rowNum)
                            throws SQLException {
                        // get user info
                        String username = rs.getString(1);
                        String password = rs.getString(2);
                        boolean enabled = rs.getBoolean(3);
                        return new User(username, password, enabled, true, true, true,
                                AuthorityUtils.NO_AUTHORITIES);
                    }

                });
    }

protected List<GrantedAuthority> loadUserAuthorities(String username) {
        return getJdbcTemplate().query(this.authoritiesByUsernameQuery,
                new String[] { username }, new RowMapper<GrantedAuthority>() {
                    @Override
                    public GrantedAuthority mapRow(ResultSet rs, int rowNum)
                            throws SQLException {
                        //get GrantedAuthority
                        String roleName = JdbcDaoImpl.this.rolePrefix + rs.getString(2);

                        return new SimpleGrantedAuthority(roleName);
                    }
                });
    }