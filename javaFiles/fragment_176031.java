//Load MS SQL JDBC Driver
    try {

        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");

    } catch (ClassNotFoundException e) {

        System.out.println(e.getMessage());

    }

    final String dbURL = "jdbc:sqlserver://ip:portnumber;databaseName=abc";
    final String username = "abc";
    final String password = "abc";

    Connection  con = null;
    PreparedStatement preparedStatement = null;
    final String selectquery = "select * from abc where TradeType = ?";
    try {
        con = DriverManager.getConnection(dbURL,username,password);
        preparedStatement = con.prepareStatement(selectquery);
        preparedStatement.setString(1, tradepair);

        // execute select SQL stetement
        ResultSet rs = preparedStatement.executeQuery();

        while (rs.next()) {

            String tradeType = rs.getString("TradeType");

            System.out.println("tradeType : " + tradeType);
        }

    } catch (SQLException e) {

        System.out.println(e.getMessage());

    } finally {

        if (preparedStatement != null) {
            preparedStatement.close();
        }

        if (con != null) {
            con.close();
        }

    }