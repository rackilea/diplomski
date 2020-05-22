public void doAction1() {
    if (!SwingUtilities.isEventDispatchThread())  {
         System.err.println("error, must be edt");
         return;
    }

    final int response = JOptionPane.showConfirmDialog(this, "Click on the YES_OPTION, busy indicator must start (if it does, try again).");

    if (JOptionPane.YES_OPTION == response) {
        startActivity();   // change glass panel in edt    

        // new thread for long standing task
        new Thread( new Runnable() { public void run() {    
           for (int i = 0; i < 5; i++) {
               try {
                   Thread.sleep(200);
               } catch (Exception e) {
                   e.printStackTrace();
               }
           }

           SwingUtilities.invokeAndWait(new Runnable(){ public void run() {
              // changing glass panel need edt
              stopActivity();
           });
        }).start();
    }
}