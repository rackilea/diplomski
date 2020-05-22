YourClass object = jdbcTemplate.query(query, new ResultSetExtractor<YourClass>() {
            @Override
            public YourClass extractData(ResultSet rs) throws SQLException, DataAccessException {
                // processing of the ResultSet
                return result;
            }
        });