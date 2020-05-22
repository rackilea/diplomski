jdbcTemplate.query(
    query,
    new ArgumentPreparedStatementSetter(new Object[] {balanceId}),
    rs -> {
       final String field1 = rs.getString("field1");
       // Get other fields and construct the resulting object
       return new YourClass(field1, ...);
    }
);