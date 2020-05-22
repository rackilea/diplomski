public void btnLoginActionPerformed() {

    db.connect();
    String sql = "Select * from user where username=? and password=?";
    try {
        pst = conn.prepareStatement(sql);
        pst.setString(1, view.getUsername());
        pst.setString(2, view.getPassword());
        rs = pst.executeQuery();

        if (rs.next()) {
            if(view.getUsername.equals("Admin"))
            {
               JOptionPane.showMessageDialog(null, "Welcome admin");
            }else
            {
               JOptionPane.showMessageDialog(null, "Welcome user");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Invalid Username or Password", "Access Denied", JOptionPane.ERROR_MESSAGE);
        }
    } catch (Exception e) {
        JOptionPane.showMessageDialog(null, e);
    }

}