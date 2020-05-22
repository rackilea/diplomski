public enum ExitCode {
  ERROR(() -> LOG.error("an error occured")),
  SUCCESS(() -> LOG.info("success")),
  FATAL(() -> {
    //more complex code here
  };

  private final Runnable r;
  ExitCode(Runnable r) { this.r = r; }

  public void log() { r.run(); }
}