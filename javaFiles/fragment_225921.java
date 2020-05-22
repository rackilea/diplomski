//...
ResultSet rset = vld.executeQuery();
if( rset.first()){
   int num = rset.getInt("num");
   boolean valid = rset.getBoolean("aval");   
}
//...