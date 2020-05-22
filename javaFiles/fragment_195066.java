try {
  server.start();
} catch (IOException e) {
  throw new RuntimeException(e);
}
// wait for a SIGINT (Ctrl+c) signal to shut down
try {
  LOG.info("Press CTRL^C to exit..");
  Thread.currentThread().join();
} catch(InterruptedException e) {
  throw new RuntimeException(e);
}