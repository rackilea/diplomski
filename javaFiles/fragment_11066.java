try {
     something.wait();
 } catch (InterruptedException e) {
     // restore the interrupted condition
     Thread.currentThread().interrupt();
 }