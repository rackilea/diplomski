jdbcTemplate.query(query, 
    new PreparedStatementSetter() {
       @Override
       public void setValues(final PreparedStatement ps) throws SQLException {
           ps.setInt(1, userId);
           ps.setFetchSize(500);
       }
    }, 
    new RowCallbackHandler() {
       @Override
       public void processRow(final ResultSet rs) throws SQLException {
         ...
       }
    });