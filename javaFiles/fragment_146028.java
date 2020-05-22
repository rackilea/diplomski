public void submitMsg(String msg) {
    AtomicInteger previous = map.putIfAbsent(msg, new AtomicInteger(1));
    if (null != previous) {
        previous.incrementAndGet();
    }
}