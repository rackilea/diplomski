for (int i=0;i < table.getRowCount(); i++) {
    String sql = "INSERT INTO temp_payment_import "
     + "(PayDate, Amount, LinkID, BranchNo) VALUES "
     + "(?, ?, ?, ?)";
    PreparedStatement ps = connect.prepareStatement(sql);
    ps.setString(1, PayDate);
    ps.setDouble(2, Double.parseDouble(Ammount));
    ps.setInt(3, Integer.parseInt(LinkID));
    ps.setInt(4, Integer.parseInt(BranchNo));
    ps.executeUpdate();
}