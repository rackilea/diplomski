ConcurrentHashMap<String,AtomicReference<BigDecimal>> map;

public void addToSum(String account, BigDecimal amount) {
    AtomicReference<BigDecimal> newSum = map.get(account);
    for (;;) {
       BigDecimal oldVal = newSum.get();
       if (newSum.compareAndSet(oldVal, oldVal.add(amount)))
            return;
    }
}