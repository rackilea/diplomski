public class Spawner {
  public static void main(String[] args) {
    Thread t = new Thread(new Runnable() {
      public void run() {
        while (true) {
          System.out.println("I'm still alive");
        }
      }
    });
    // Try uncommenting/commenting this line
    // t.setDaemon(true);
    t.start();
    System.out.println("Main thread has finished");
  }
}