try{
    // 1. Get a connection do database
    myConn = DriverManager.getConnection(connectionUrl);
    // 2. Create a statement
    Statement myStmt = myConn.createStatement();
    // 3. Execute SQL query
    String sql = "";
    //int rowsAffected = myStmt.executeUpdate(sql);
    //System.out.println("Rows affected " + rowsAffected);
    // 4. Process the result set
}