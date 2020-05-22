java.sql.Statement statement = conn.createStatement();
String sql = "SELECT MAX(GiaSP) from tbsanpham where manhom = '"+manhom+"'";
ResultSet rs = statement.executeQuery(sql);
if (rs.next()) {
    max = rs.getInt(1);
}