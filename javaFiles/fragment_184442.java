List<Conversation> actors = jdbcTemplate.query(
    SELECT_ALL_CONVERSATIONS_SQL_FULL,
    new Object[] {userId, dateFrom, dateTo},
    new RowMapper<Conversation>() {
        public Conversation mapRow(ResultSet rs, int rowNum) throws SQLException {
            Conversation c = new Conversation();
            c.setId(rs.getLong(1));
            c.setRoom(rs.getString(2));
            [...]
            return c;
        }
    });