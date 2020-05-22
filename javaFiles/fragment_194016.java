java.awt.Dialog awtDialog = ...        
      Shell shell = new Shell(parent, SWT.APPLICATION_MODAL | SWT.NO_TRIM);
      shell.setSize(0, 0);
      shell.addFocusListener(new FocusAdapter() {
          public void focusGained(FocusEvent e) {
              awtDialog.requestFocus();
              awtDialog.toFront();
          }
      });