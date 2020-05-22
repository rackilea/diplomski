private static long lastMillis = 0;

static synchronized long nextMillis() throws InterruptedException {
  long nextMillis;
  while ((nextMillis = System.currentTimeMillis()) == lastMillis) {
    Thread.sleep(1);
  }
  return lastMillis = nextMillis;
}