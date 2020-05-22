class Demo{

    public static java.lang.String getUser() 
                                         throws java.sql.SQLException {

    java.sql.Statement stmt = null;
    java.sql.ResultSet rs = null;

    try{
        java.sql.Connection con = 
                java.sql.DriverManager.getConnection("jdbc:default:connection");

        java.lang.String query = 
                  "SELECT SYS_CONTEXT('USERENV', 'CURRENT_USER')," +
                  "SYS_CONTEXT('USERENV', 'SESSION_USER') FROM DUAL";


        stmt  = con.createStatement();
        rs = stmt.executeQuery(query);

        rs.next();

        return "Current User: [" + rs.getString(1) + "] ; " +
               "Session User: [" + rs.getString(2) + "]";
    }
    finally{
        rs.close();
        stmt.close();
    }

    }

}