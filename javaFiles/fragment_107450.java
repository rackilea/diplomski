button.setEnabled(false);
new Thread(new Runnable() {
 public void run() {
  // Do heavy lifting here
  SwingUtilies.invokeLater(new Runnable() {
   public void run() {
    button.setEnabled(true);
   }
  });
 }
}).start();