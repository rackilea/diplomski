public static void main(String[] args) {
  for(;;) {
    try {
      Thread.sleep(5000);
      System.out.println("Test output");
    } catch(InterruptedException e) {
      // Ignore
    }

  }
}