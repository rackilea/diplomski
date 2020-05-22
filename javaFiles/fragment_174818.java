class Scheduler {
    private final Map<String, Long> map = new HashMap<>();
    private final long interval = 200; // ms
    public void sleepAsLongAsNecessary(String key) {
        long now = System.currentTimeMillis();
        long deadline = next(now, key);
        while (now < deadline) {
            Thread.sleep(deadline - now);
            now = System.currentTimeMillis();
        }
    }
    private synchronized long next(long now, String key) {
        Long oldValue = map.get(key);
        long newValue = oldValue == null ? now : Math.max(oldValue + interval, now);
        map.put(key, newValue);
        return newValue;
    }
}