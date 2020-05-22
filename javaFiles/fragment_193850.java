Connection con = null;
Statement stmt = null;
ResultSet rs = null;

try {
    // get a connection, statement and result set, in this order
    // make your JDBC calls here
} catch (Exception e) {
    // handle all exceptions here
} finally {
     try {
         try {rs.close();} catch (Exception e) {}
         try {stmt.close();} catch (Exception e) {}
          // Note that we will attempt to close the database connection even
          // if something went wrong with closing the statement or result set
         try {con.close();} catch (Exception e) {}
     } catch (Exception e) {  }
}