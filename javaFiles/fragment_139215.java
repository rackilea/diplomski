String sql = "SELECT combo FROM `leave`";
try (Connection con = Connect.ConnectDB();
        PreparedStatement pst = con.prepareStatement(sql);
        ResultSet rs = pst.executeQuery()) {
    if (rs.next()) {
        String nm = rs.getString("combo");
        jComboBox1.addItem(nm);
    }
} catch (Exception e) {
    JOptionPane.showMessageDialog(null, e);
}