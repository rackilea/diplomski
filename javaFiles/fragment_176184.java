int maxID = 0;
String sql = "SELECT MAX(idCustomer) AS max_id FROM customers";
PreparedStatement ps = conn.prepareStatement(sql);
ResultSet rs = ps.executeQuery();
if (rs.next()) {
    int maxID = rs.getInt("max_id");  // access the max value via its alias
}