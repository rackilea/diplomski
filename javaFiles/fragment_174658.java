ResultSet rs1 = stmt.executeQuery();

if (rs1.next()) {
    Integer qty = rs1.getInt(1);
    ...
}