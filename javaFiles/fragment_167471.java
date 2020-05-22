con = (YourDB/urDBconnectingClassName)
  try {
    String sql = "insert into month (No,Description,Sale,Expense,Total)
                  values (?,?,?,?,?)";
    pst = conn.prepareStatement(sql);
    pst.setString(1, txt_srM.getText());
    pst.setString(2, txt_dateM.getText());
    pst.setString(3, txt_tsaleM.getText());
    pst.setString(4, txt_texpM.getText());
    pst.setString(5, txt_subtM.getText());
    pst.execute();
    JOptionPane.showMessageDialog(null, "Saved!");
} catch (Exception e) {
    JOptionPane.showMessageDialog(null, e);
}