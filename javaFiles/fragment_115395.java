Connection con;
try {
  con=DBConnectionUtil.getConnection();
  //some code here
} finally {
  if(con!=null){
      con.close();
  }