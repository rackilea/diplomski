getJdbcTemplate().query(query, rs -> {
        process(rs);
        return null;
      });

private void process(ResultSet rs) {
    while (rs.next()) {
        //do something
    }
}