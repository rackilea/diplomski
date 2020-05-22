new Thread() {
   public void run() {
      while(runBackgroundThread) {
         mcr.getData();
         repaint();
      }
   }
}.start();