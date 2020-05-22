synchronized(left) {
   synchronized (right) {
       Thread lThread = new Thread(…);
       Thread rThread = new Thread(…);
       lThread.start();
       rThread.start();
       try {
         left.wait();
         right.wait();
       }
       …