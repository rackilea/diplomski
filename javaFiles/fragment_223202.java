IDbAction action = new IDbAction(){

    public DbActionResult prcoessAction(Connection conn){
        Statement stmt = conn.createStatement();
        ResultSet rst = stmt.executeQuery("SELECT 'Success obtaining connection' FROM DUAL");

        if (rst.next()) message = rst.getString(1);

        return new DbActionResult(stmt, rst);
    }

}

runAgainstDB(action);