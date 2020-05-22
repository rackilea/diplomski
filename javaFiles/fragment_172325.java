private void saveActionPerformed(java.awt.event.ActionEvent evt) {                                     
        // TODO add your handling code here:
    String sql="INSERT INTO photo(image) VALUES(?)";
    try {
        stmt=con.prepareStatement(sql);
        stmt.setBytes(1, image);
        stmt.executeUpdate();
        JOptionPane.showMessageDialog(null,"Saved Successfully into Database...!");
    } catch (SQLException ex) {
        Logger.getLogger(Photo.class.getName()).log(Level.SEVERE, null, ex);
    }                   
}