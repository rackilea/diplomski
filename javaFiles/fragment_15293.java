private void startButtonActionPerformed(java.awt.event.ActionEvent evt) {                                            
    statusTextField.setText("Processing files.");
    int startLine = Integer.parseInt(startLineTextField.getText());
    new Thread() {
      public void run() {
        try {
          if (selectedFile != null) {  
           ...      
          SwingUtilities.invokeLater(new Runnable() {
            public void run() {
              statusTextField.setText("Finished !");
            }
          });
        } catch (Exception ex) {
          ...
        }
    }.start();
  }