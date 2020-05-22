Connection con = null;
Statement stmt = null;
ResultSet rs = null;

try{
  ....//your lohic
}catch(SQLException e){}
}finally{
   try{
      if (rs != null)
        rs.close();
      if (stmt != null) 
        stmt.close();
      if (con != null) 
        con.close();
   }catch(SQLException e){}
}