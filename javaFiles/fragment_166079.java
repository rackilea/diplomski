String query = "select * from TEST_TABLE where ID = 1";
PreparedStatement statement = connection.prepareStatement(query, ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
ResultSet uprs = statement.executeQuery();
uprs.next();
uprs.updateString("TEST_CHAR", testName);
uprs.updateRow();