public class DBAccess {

    private Statement s;

    DBAccess() {
        try {
            Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
            String database = "jdbc:odbc:Driver={Microsoft Access Driver (*.mdb)};DBQ=CFPDB.mdb;";
            Connection conn = DriverManager.getConnection(database, "", "");
            s = conn.createStatement();
        }
        catch(Exception ex) {
            ex.printStackTrace();
        }
    }

    public Statement getStatement() {
        return s;
    }
}