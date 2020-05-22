public class WorkThread extends Thread {
...
   static Object lock = new Object();
...
   public void checkTurn(int id) {
     synchronized (lock) {
        while (id != printNowId) {
            try {
                lock.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
     }
  }

   public void done() {
     synchronized (lock) {
        printNowId = printNowId + 1;
        lock.notifyAll();
     }
   }
...