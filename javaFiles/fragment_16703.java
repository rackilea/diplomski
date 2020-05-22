public final class ThreadExample implements Runnable {
  public static void main(String[] args) {
    Thread thread = new Thread(new ThreadExample());
    thread.start();
    System.out.println("Exit the main");
  }

  public void run() {
    while (true) {
      System.out.println("Current time: " + (new Date()).getTime());
      try {
        Thread.sleep(1000);
      } catch (InterruptedException e) {
        System.out.println("Error: " + e.getMessage());
      }
    }
  }
}