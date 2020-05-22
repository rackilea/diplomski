Connection con = null;
PreparedStatement prest;
try{
  Class.forName("com.mysql.jdbc.Driver");
  con = DriverManager.getConnection("jdbc:mysql://<server>:3306/<db>","<login>","<pass>");
  try{
    String sql = "SELECT * FROM table WHERE timestamp_col=(SELECT MAX(timestamp_col) FROM table)";
    prest = con.prepareStatement(sql);
    // prest.setInt(1,12000); // example of using a parameter for prepared statement
    // parameters go in the SQL as ?
    ResultSet rs1 = prest.executeQuery();
  } catch( SQLException s ) { /* etc */ }