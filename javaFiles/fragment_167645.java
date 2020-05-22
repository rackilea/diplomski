public static class Addition {
  int a, b;

  public void add(int a, int b) throws InterruptedException {
    int sum = 0;
    synchronized (this) {
      for (int i = a; i <= b; i++) {
        sum = sum + i;
        Thread.sleep(1000);
      }
      System.out.println("Sum=" + sum);
    }
  }
}