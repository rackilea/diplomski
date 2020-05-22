List<YourClass> result = jdbcTemplate.query(query, new RowMapper<YourClass>() {
            @Override
            public YourClass mapRow(ResultSet rs, int i) throws SQLException {
                // processing of the ResultSet
                return result;
            }
        });