private void btnRunBckActionPerformed(java.awt.event.ActionEvent evt)     
{

        // TODO add your handling code here:
        String error;

        btnRunBackup runBackupObject = new btnRunBackup();

        error = runBackupObject.checkStatus();

        lblRunBck.setText(error == null ? "No error" : error);
}