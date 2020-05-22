boolean rs = false;
String sql = "INSERT INTO test (ID, record_date) values(?, NVL(?, sysdate()))";
PreparedStatement pstmt = DBConnection.getConnection().prepareStatement(sql);
pstmt.setString(1, para1);
if (para2 == null)
    pstmt.setNull(2, Types.Date);
else
    pstmt.setDate(2, para2);
rs = (pstmt.executeUpdate() > 0);