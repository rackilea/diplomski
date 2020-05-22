void onFailure(String hostname) {
    // you can use `computeIfAbsent` in java8
    AtomicInteger val = blockedHosts.computeIfAbsent(hostname, key -> new AtomicInteger());
    int count = val.incrementAndGet();
    // the test here is `==` to make sure the task is scheduled only once
    if (count == threshold) {
        scheduler.schedule(() -> blockedHosts.remove(hostname), 5L, TimeUnit.MINUTES);  // or you may choose to just decrement the counter
    }
}