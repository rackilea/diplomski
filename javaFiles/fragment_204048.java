//create table
PreparedStatement ps = conn.prepareStatement(sql);
for(int i =0; i < rows.length; ++i) {
  if(i != 0 && i%5 == 0) {
    pstmt.executeBatch();
  }
  pstmt.setString(1, rows[i].getName());
  pstmt.setLong(2, rows[i].getId());
  pstmt.addBatch();
}
pstmt.executeBatch();