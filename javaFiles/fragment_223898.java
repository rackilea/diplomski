barMenu.addSelectionListener(new SelectionAdapter() {
        @Override
        public void widgetSelected(SelectionEvent arg0) {
            // invoke later to give event time to finish, and have
            // the menu item deselected
            javax.swing.SwingUtilities.invokeLater(new Runnable() {
              public void run() {
              // wait
              try { Thread.currentThread().sleep(100);} catch(Exception ex){}
              // jump back to the SWT thread and do the actual work
              Display.getDefault().asyncExec(new Runnable() {
              public void run() {
               createShell(shell);
              }});
            }});
        }
    });