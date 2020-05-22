public static class TCP_Ping implements Runnable {
  // these are the fields:
  private final int a;
  private final String b;

  // this is the constructor, that takes parameters
  public TCP_Ping(final int a, final String b) {
    // here you save the parameters to the fields
    this.a = a;
    this.b = b;
  }

  // and here (or in any other method you create) you can use the fields:
  @Override public void run() {
    System.out.println("a: " + a);
    System.out.println("b: " + b);
  }
}