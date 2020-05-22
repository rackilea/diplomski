private static final ConcurrentMap<String, AtomicInteger> exceptionMap = new ConcurrentHashMap<String, AtomicInteger>();

private static void addException(String cause) {
  AtomicInteger count = exceptionMap.get(cause);
  if(count == null) {
    count = new AtomicInteger();
    AtomicInteger curCount = exception.putIfAbsent(cause, count);
    if(curCount != null) {
      count = curCount;
    }
  }
  count.incrementAndGet();
}