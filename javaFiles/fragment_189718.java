String SQL = "select i_out, str_out from test_function1(:id)";
SqlParameterSource namedParameters = new MapSqlParameterSource("id", request.getIntTestVar());

List<TRPerson> result = namedTemplate.query(SQL, namedParameters, new RowMapper() {

    @Override
    public TRPerson mapRow(ResultSet rs, int i) throws SQLException {
        TRPerson result = new TRPerson();
        result.setIntVar(rs.getInt("i_out"));
        result.setStrVar(rs.getString("str_out"));
        return result;
    }
});