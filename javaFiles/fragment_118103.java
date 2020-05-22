PreparedStatement pstmt = connection.prepareStatement("select data from my_table where id = ?");
pstmt.setInt(1, 42);
ResultSet rs = psmt.executeQuery();
if (rs.next()) {
  String jsonData = rs.getString(1);
}