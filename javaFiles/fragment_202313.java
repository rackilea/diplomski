try {
                Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
                String url="jdbc:sqlserver://localhost:1433;databaseName=77OOP062;user=sa;password=hnd";
                Connection conn= DriverManager.getConnection(url);
                String sql ="Select Type from Users where Username=? and Password=?";
                PreparedStatement pst =conn.prepareStatement(sql);
                pst.setString(1, jTextFieldUserName.getText());
                pst.setString(2, jTextFieldPassword.getText());
                ResultSet rs = pst.executeQuery();
    if(rs.next()){ // Row Exists
                String name = rs.getString("Type");

    if (name.equals("admin")) {
                JOptionPane.showMessageDialog(null, "Access Permitted");
            ManageUI ah = new ManageUI();
            ah.setVisible(true);
                }

                else if (name.equals("cashier")){
            JOptionPane.showMessageDialog(null, "Access Permitted");
                CashierUI eh = new CashierUI();
                eh.setVisible(true);
        }
                else if (name.equals("stockkeeper")){
                JOptionPane.showMessageDialog(null, "Access Permitted");
            StockKeeperUI aq = new StockKeeperUI();
                aq.setVisible(true);
        }else {
                JOptionPane.showMessageDialog(null, "Access Denied");
        }
  } else{
JOptionPane.showMessageDialog(null, "Access Denied"); // Row Doesnot exists
}
    conn.close();
    }
   catch (Exception e){
        JOptionPane.showMessageDialog(null, e);
    }