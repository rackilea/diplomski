public void actionPerformed(ActionEvent evt) {

     // *** first get the selected Player from the JList
     Player player = (Player) playerList.getSelectedValue();
     if (player == null) {
        return; // do nothing if no player selected
     }

     // then create a PlayerEditorPanel object
     PlayerEditorPanel editorPanel = new PlayerEditorPanel();

     // and then "inject" the selected Player into the editor panel.
     editorPanel.setPlayer(player);

     // and display it in a JOptionPane
     int result = JOptionPane.showConfirmDialog(PlayerStats.this,
           editorPanel, "Edit Player", JOptionPane.OK_CANCEL_OPTION,
           JOptionPane.PLAIN_MESSAGE);
     if (result == JOptionPane.OK_OPTION) {
        editorPanel.upDatePlayerAttributes();
        playerList.repaint();
     }
  }