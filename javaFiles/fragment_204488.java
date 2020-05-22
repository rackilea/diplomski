try {
    DataSource ds = (DataSource)context.lookup("jdbc/mypool");
    conn = ds.getConnection();
    cs = conn.prepareCall( "{call mysproc (?,?)}" );
    cs.setString(1, xy);
    cs.setString(2, zz);
    cs.execute();

} catch ( SQLException exp ) {
  //Handle your exception
} finally {  
  if (conn != null ) {
      try {
         conn.close(); 
      } catch(SQLException sqlExp){
         // Handle your exception     
      }
      conn = null;
    }
}