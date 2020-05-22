protected List<UserDetails> loadUsersByUsername(String username) {
        return getJdbcTemplate().query(this.usersByUsernameQuery,
                new String[] { username }, new RowMapper<UserDetails>() {
                    @Override
                    public UserDetails mapRow(ResultSet rs, int rowNum)
                            throws SQLException {
                        String username = rs.getString(1);
                        String password = rs.getString(2);
                        boolean enabled = rs.getBoolean(3);
                        return new User(username, password, enabled, true, true, true,
                                AuthorityUtils.NO_AUTHORITIES);
                    }

                });
    }