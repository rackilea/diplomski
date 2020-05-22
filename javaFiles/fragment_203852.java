boolean someThreadStillAlive = true;
while (someThreadStillAlive) {
  someThreadStillAlive = false;
  Thread.sleep(200);
  for (Thread t : fetchAndParseThreads) {
    someThreadStillAlive = someThreadStillAlive || t.isAlive();
  }
}