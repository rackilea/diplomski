public ResultSet execQuery() throws SQLException, ClassNotFoundException{
    //Load the database driver
    Class.forName("oracle.jdbc.OracleDriver");

    //Create connection to the database
    Connection myConnection = DriverManager.getConnection(connectURL,userName,userPwd);

    //Create a statement link to the database for running queries
    Statement myQuery = myConnection.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);

    //Create a resultSet to hold the returned query information
    ResultSet myQueryResults = myQuery.executeQuery("select * from SCHEMA.TABLE@DBLINK_NAME");       

    return myQueryResults;
}