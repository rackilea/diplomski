interface FileDetectedHandler { void fileDetected(File f); }

public static void main(String[] args) {
  final ScheduledExecutorService scheduler = 
     Executors.newSingleThreadScheduledExecutor();
  final FileDetectedHandler h = new FileDetectedHandler(File f) {
    public void fileDetected(File f) {
      System.out.format("File detected: %s\n", f);
  }};
  final Runnable r = new Runnable() { public void run() {
    File f = null;
    //detect file
    if (f != null) h.fileDetected(f);
  }};
  scheduler.scheduleWithFixedDelay(r, 0, 2, TimeUnit.SECONDS);
}