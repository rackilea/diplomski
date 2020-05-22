Class.forName("org.sqlite.JDBC");

    con = DriverManager.getConnection("jdbc:sqlite:" + "unique");
    prep = con.prepareStatement(ANOTHER_SQL);

    Statement statement = con.createStatement();
    statement.executeUpdate("some sql");

    con.setAutoCommit(false);