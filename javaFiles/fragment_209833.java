Runtime.getRuntime().addShutdownHook(new Thread() {
  @Override 
  public void run() {
    // Code to be executed when JVM exits
    System.out.println("JVM exit");
  }
});