public MainPage() {
     this.checkWindow = new CheckWindow()
 }

 private void btn_callCheckBoxActionPerformed(java.awt.event.ActionEvent evt)  {                                         
        // show window
        this.checkWindow.setVisible(true);
        this.checkWindow.setEnabled(true);

        this.setVisible(true);
        this.setEnabled(false);
  }