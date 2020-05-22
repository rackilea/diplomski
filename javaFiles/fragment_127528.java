String sql = "select * from employee where empname=?";//question mark
user=request.getParameter("uname");
pass=request.getParameter("pwd");
try {
  PreparedStatement pStmt = con.prepareStatement(sql);
  pStmt.setString(1, user); // set first question mark
  ResultSet  rs = pStmt.executeQuery();
  String username=null;
  String password=null;
  if(rs.next()){
    username=rs.getString(2);
    password=rs.getString(3);
  }
}