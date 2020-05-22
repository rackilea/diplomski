String sql = "select * from t1";
    Object[] params = new Object[] { 1001 };
    JdbcTemplate t = EasyMock.createMock(JdbcTemplate.class);
    EasyMock.expect(
            t.queryForObject(sql, String.class, params)).andReturn("res");
    EasyMock.replay(t);