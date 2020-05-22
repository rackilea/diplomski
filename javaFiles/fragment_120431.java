private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {
    try {
        // MashIsGood.main(arguments);
        MashIsGood.startThread(this);
    } catch (IOException ex) {
        Logger.getLogger(MashForm.class.getName()).log(Level.SEVERE, null,ex);
    }
}