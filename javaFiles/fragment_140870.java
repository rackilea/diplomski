PreparedStatement pst__ = null;
try{   
  pst__ = connectionUsers.prepareStatement(query3);
  pst__.setString(1, x);
  pst__.setString(2, x1);
  pst__.setString(3, x2); 
  ts2 = pst__.executeQuery();
}finally{
  if(pst__ != null) {
    pst__.close();
  }
}