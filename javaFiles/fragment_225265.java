public class TheThing extends Thread {
    public void run() {
       while (!Thread.currentThread().interrupted()) {
          ...
       }
    }
}