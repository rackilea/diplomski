String sql = "insert into table (column1, column2) values (?, ?);
    try(Connection  c = dataSource.getConnection();
    PreparedStatement s = c.prepareStatement(sql);) {


        int i = 1;
        s.setString(i++, "111");
        s.setString(i++, "222");

        s.execute();

    } catch (SQLException e) {
        log.error("Failed to insert transaction", e);
    }