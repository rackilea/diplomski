jdbcTemplate.query("", new ResultSetExtractor<Object>() {

    @Override
    public Object extractData(ResultSet rs) throws SQLException,
            DataAccessException {
        //do what ever you want to do with rs
        return null;
    }
});