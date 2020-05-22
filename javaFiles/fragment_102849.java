// Network thread
 final Message msg = getMessage();
 SwingUtilities.invokeLater(new Runnable() {
   public void run() {
      // This code will be executed on the EDT
      // it can access the msg variable because it is final
   }
 });