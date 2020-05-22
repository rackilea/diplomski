PreparedStatement pstmt = con.prepareStatement("select * from getData(?)")
pstmt.setInt(1,5);
ResultSet rs = pstmt.execute(); 
while (rs.next()) {
  System.out.println(rs.getString(1));
}