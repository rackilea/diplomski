public ResultSet retrieveSQLQuery(String sqlQuery) {            
    try (Connection conn = DriverManager.getConnection(dbUrl, user, password);
         Statement statement = conn.createStatement();
         ResultSet rs = statement.executeQuery(sqlQuery)) {
        MyResult result = ...; // parse rs here
        return myResult;               
    } catch (SQLException e) {
        logger.info(e.getMessage());
        // return something (empty MyResult or null) from here or rethrow the exception
        // I'd recommend to get rid of this catch block and declare the SQLException on method signature
    }                    
}