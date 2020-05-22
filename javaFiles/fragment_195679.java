Statement stmt = con.createStatement();
stmt.executeQuery("sp_help " + table);
stmt.getMoreResults();
stmt.getMoreResults();
ResultSet rs = stmt.getResultSet();
//...
while( rs.next() )
   boolean identity = rs.getBoolean("Identity");