String query = "select * from TEST_TABLE where ID = 1";
Statement statement = connection.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
ResultSet executeQuery = statement.executeQuery(query);
executeQuery.next();
executeQuery.updateString("TEST_CHAR", testName);
executeQuery.updateRow();