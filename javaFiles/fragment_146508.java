Class.forName("org.sqlite.JDBC");

    con = DriverManager.getConnection("jdbc:sqlite:" + "unique");

    Statement statement = con.createStatement();
    statement.executeUpdate("some sql");

    con.setAutoCommit(false);

    prep = con.prepareStatement(ANOTHER_SQL);