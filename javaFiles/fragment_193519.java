String sql = "INSERT INTO table (column1, column2) values(?, ?)";
stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);


stmt.executeUpdate();
if(returnLastInsertId) {
   ResultSet rs = stmt.getGeneratedKeys();
    rs.next();
   auto_id = rs.getInt(1);
}