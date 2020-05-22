try {
    String query = "select * from dbo.Table";
    String width = jFormattedTextField1.getText();
    String height = jFormattedTextField2.getText();
    PreparedStatement ps;

    if (width.equals("") && height.equals("")) {
        ps = conn.prepareStatement(query);
    } else if (width != null && !"".equals(width) && height != null && !"".equals(height)) {
        query += " where width = ? and height = ?";
        ps = conn.prepareStatement(query);
        ps.setString(1, width);
        ps.setString(2, height);
    } else if (width != null && height.equals("")){
        query += " where width = ?";
        ps = conn.prepareStatement(query);
        ps.setString(1, width);

    } else {
        query += " where height = ?";
        ps = conn.prepareStatement(query);
        ps.setString(1, height);
    }
    ResultSet rs = ps.executeQuery();
    jTable1.setModel(DbUtils.resultSetToTableModel(rs));
} catch (Exception e) {
    JOptionPane.showMessageDialog(null, e, "ERROR", JOptionPane.ERROR_MESSAGE);
}