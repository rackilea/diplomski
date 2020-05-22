DBAccess() {
    try {
        Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
        String database = "jdbc:odbc:Driver={Microsoft Access Driver (*.mdb)};DBQ=CFPDB.mdb;";
        Connection conn = DriverManager.getConnection(database, "", "");
        Statement s = conn.createStatement();
        s.execute(""); // compiles without problem.
    }
    catch(Exception ex) {
        s.execute(""); // does not compile.
        ex.printStackTrace();
    }
    s.execute(""); // does not compile.
}