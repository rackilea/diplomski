interface IDbAction {
    public DbActionResult runAction(Connection conn);
}

class DbActionResult {

    Statement statement;
    ResultSet resultSet;

    public DbActionResult(Statement statement, ResultSet resultSet){
        this.statement = statement;
        this.resultSet = resultSet;
    }

    public void getStatement(){ return this.statement; }
    public void getResultSet(){ return this.resultSet; }
}

public void runAgainstDB(IDbAction action) {

    Connection conn = null;
    ResultSet rst = null;
    Statement stmt = null;

    try {

        //SETUP 
        Context initContext = new InitialContext();
        Context envContext = (Context) initContext.lookup("java:/comp/env/jdbc");
        OracleDataSource ds = (OracleDataSource) envContext.lookup("tclsms");

        if (envContext == null) throw new Exception("Error: No Context");
        if (ds == null) throw new Exception("Error: No DataSource");
        if (ds != null) conn = ds.getConnection();
        if (conn == null) throw new Exception("Error: No Connection")

        message = "Got Connection " + conn.toString() + ", ";

        //BODY 
        DbActionResult actionResult = action.runAction(conn);

        //TEAR DOWN 

        if((rst = actionResult.getResultSet()) != null){
            rst.close();
            rst = null;
        }

        if((stmt = actionResult.getStatement()) != null){
            stmt.close();
            stmt = null;
        }

        actionResult = null;

        conn.close(); // Return to connection pool
        conn = null; // Make sure we don't close it twice
    } catch (Exception e) {
        e.printStackTrace();
        //TODO proper error handling 
    } finally {
        // Always make sure result sets and statements are closed,
        // and the connection is returned to the pool
        if (rst != null) {
            try {
                rst.close();
            } catch (SQLException e) {;}
            rst = null;
        }

        if (stmt != null) {
            try {
                stmt.close();
            } catch (SQLException e) {;}
            stmt = null;
        }

        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException e) {;}
            conn = null;
        }
    } //END FINALLY
} //END