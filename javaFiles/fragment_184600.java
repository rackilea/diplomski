private final ConcurrentHashMap<String, AtomicInteger> failedCallCount = new ConcurrentHashMap<>();

void call() {
      try {
          String url = createURL(host);
          // make rest call
          resetFailedCallCount(host);
          // ...
      } catch (RestClientException ex) {
          registerFailedCall(host);
          if (shouldBeBlocked(host)) {
              DataMapping.blockHost(host);
          }
      }
}


private boolean shouldBeBlocked(String hostName) {
    AtomicInteger count = failedCallCount.getOrDefault(hostName, new AtomicInteger());
    return count.get() >= 5;
}

private void registerFailedCall(String hostName) {
    AtomicInteger newValue = new AtomicInteger();
    AtomicInteger val = failedCallCount.putIfAbsent(hostName, newValue);
    if (val == null) {
        val = newValue;
    }
    if (val.get() < 5) {
        val.incrementAndGet();
    }
}

private void resetFailedCallCount(String hostName) {
    AtomicInteger count = failedCallCount.get(hostName);
    if (count != null) {
        count.set(0);
    }
}