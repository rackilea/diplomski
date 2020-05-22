void onFailure(String hostname) {
    AtomicInteger newValue = new AtomicInteger();
    AtomicInteger val = blockedHosts.putIfAbsent(hostname, newValue);
    int count = (val == null ? newValue : val).incrementAndGet();
    // the test here is `==` to make sure the task is scheduled only once
    if (count == threshold) {
        scheduler.schedule(new Runnable() {
            @Override public void run() {
                blockedHosts.remove(hostname);  // or you may choose to just decrement the counter
            }
        }, 5L, TimeUnit.MINUTES);
    }
}