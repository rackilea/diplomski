Runtime.getRuntime().addShutdownHook(new Thread() {
  public void run() {
      ...
      writer.flush();
  }
});