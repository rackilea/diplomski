String query = "INSERT INTO `supplier`(`Company Name`, `Contact`, `Address`, `Postcode`, `Phone`) "
    + "VALUES (?, ?, ?, ?, ?)";
try (PreparedStatement pstm = conn.prepareStatement(query)) {
    pstm.setString(1, jTextField_SupplierCompany.getText());
    pstm.setString(2, jTextField_SupplierContact.getText());
    pstm.setString(3, jTextField_SupplierAddress.getText());
    pstm.setString(4, jTextField_SupplierPostcode.getText());
    pstm.setString(5, jTextField_SupplierPhone.getText());

    pstm.executeUpdate();
}