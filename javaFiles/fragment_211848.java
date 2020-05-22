Statement stmt = conn.createStatement();
try {
    ResultSet rs = stmt.executeQuery( "SELECT FULL_NAME FROM EMP" );
    try {
        while ( rs.next() ) {
            System.out.println( "Name: " + rs.getString("FULL_NAME") );
        }
    } finally {
        try { rs.close(); } catch (Exception ignore) { }
    }
} finally {
    try { stmt.close(); } catch (Exception ignore) { }
}