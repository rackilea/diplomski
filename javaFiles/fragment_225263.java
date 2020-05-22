public class TheThing extends Thread {
    volatile boolean shutdown = false;
    public void run() {
       while (!shutdown) {
          ...
          // you can also test for shutdown while processing
          if (shutdown) {
             return;
          }
       }
    }
}