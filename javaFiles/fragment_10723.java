String sql = "INSERT INTO node (type, language, title) VALUES (?, ?, ?)";
PreparedStatement pstmt = conn.prepareStatement(sql);
try
{
    pstmt.setString(1, node.get("type"));
    pstmt.setString(2, node.get("language"));
    pstmt.setString(3, node.get("title"));
    pstmt.executeUpdate();
}
finally
{
    pstmt.close(); 
}