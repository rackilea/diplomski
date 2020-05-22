private void openDialogActionPerformed(java.awt.event.ActionEvent evt) {
    int response = JOptionPane.showOptionDialog(this, "Do you wish to save", "Save", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, null, null);
    if (response == JOptionPane.YES_OPTION) {
        save(1);
    }
}