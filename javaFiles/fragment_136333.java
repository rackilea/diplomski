connect();
Statement statement = connection.createStatement();

String query2 = "SET NAMES 'utf8'";
statement.execute(query2);

query2 = "SET CHARACTER SET 'utf8'";
statement.execute(query2);

ResultSet resultSet = statement.executeQuery(query);