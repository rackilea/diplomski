String sql = "INSERT INTO Order "
    + "(date, totalAmount, deliveryStatus, deliveryDate, invoiceId, customerId) VALUES "
    + "(?,?,?,?,?,?)";
try (Connection conn = DBConnection.getInstance().getDBcon();
    PreparedStatement ps = conn.prepareStatement(sql)) {
    ps.setDate(1, date);
    ps.setInt(2, totalAmount);
    ps.setString(3, deliveryStatus);
    ps.setDate(4, deliveryDate);
    ps.setInt(5, invoiceId);
    ps.setInt(6, customerId);
    ps.executeUpdate();
} catch(SQLException e) {
    e.printStackTrace();
    throw e;
}