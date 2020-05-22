Class.forName("com.mysql.jdbc.Driver").newInstance();
Connection connection = DriverManager.getConnection(
                        "jdbc:mysql://insert_address_here/",
                        "user","password");
Statement statement   = connection.createStatement();
ResultSet result = statement.executeQuery(
     "SELECT * FROM sometable WHERE id = 1");