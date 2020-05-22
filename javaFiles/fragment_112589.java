Map<KeyType, AtomicInteger> map = ...

synchronized(map) {
   AtomicInteger count = map.get(key);
   if (count == null)
       map.put(key, count = new AtomicInteger());
   count.incrementAndGet();
}