String sql = "INSERT INTO SetUpReward VALUES(?,?,?,?,?,?)";
try {
    if (con != null) {
        pst = con.prepareStatement(sql);
        pst.setString(2, txt_minGiftValue.getText());
        pst.setString(3, txt_maxGiftValue.getText());
        pst.setString(4, txt_RewardPoint.getText());
        pst.setString(5, txt_CardNumber.getText());
        pst.setString(6, txt_PayPalEmail.getText());
        pst.setString(7, txt_BankName.getText());
        pst.setString(8, txt_BankAccount.getText());
        pst.execute();
    } else {
        System.out.println("No connection");
    }
} catch (SQLException e) {
    JOptionPane.showMessageDialog(null, e);
    e.printStackTrace();
}