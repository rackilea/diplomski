private void jLabelCreateMouseClicked(java.awt.event.MouseEvent evt) {                                          
        myConnection con = new myConnection();
        String sql = "INSERT INTO `user`(`username`, `pass`, `mail`) VALUES (?, ?, ?)";
        try {
            PreparedStatement ps = con.connect().prepareStatement(sql);
            ps.setString(1, jTextField1.getText());
            ps.setString(2, String.valueOf(jPasswordField1.getPassword()));
            ps.setString(3, jTextField3.getText());
            if (ps.executeUpdate() != 0) {
                JOptionPane.showMessageDialog(null, "Account Created");
            } else {
                JOptionPane.showMessageDialog(null, "Failed");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            con.disconnect();
        }
    }