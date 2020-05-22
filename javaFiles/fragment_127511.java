private void runInTemplate() {
    this.jdbcTemplate.update(
            "insert into t_customer " +
                    "(id, first_name, last_name, last_login, comments) " +
                    "values (?, ?, ?, ?, ?)",
            new PreparedStatementSetter() {
                public void setValues(PreparedStatement ps)
                        throws SQLException {
                    ps.setLong(1, 2L);
                    ps.setString(2, "Jan");
                    ps.setString(3, "Machacek");
                    ps.setTimestamp(4,
                            new Timestamp(System.currentTimeMillis()));
                    lobHandler.getLobCreator().setClobAsString(ps, 5,
                            "This is a loooong String!");
                }
            });
}