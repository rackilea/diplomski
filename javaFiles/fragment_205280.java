public void performDatabaseOperation(...) {
    // initialize properties here, load driver etc. here

    try (Connection con = DriverManager.getConnection(url, user, pwd)) {
        // use connection.
        // it will be closed automatically at the end of this code block
        // even if exceptions occure!
    }
}