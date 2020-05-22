int rowsAffected = createPlayer.executeUpdate();

if(rowsAffected > 0) {
   JOptionPane.showMessageDialog(null, "Player successfully deleted!");
}
else{
    JOptionPane.showMessageDialog(null, "Player does not exist!", "notdeleted", JOptionPane.ERROR_MESSAGE);
}