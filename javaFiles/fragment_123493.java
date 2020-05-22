static AtomicInteger currentNumberOfThreads = new AtomicInteger();
public void concurrentMethod(Object data) {
  currentNumberOfThreads.incrementAndGet();
  try {
    // currentNumberOfThreads.gets() 
  } finally {
    currentNumberOfThreads.decrementAndGet();
  }
}