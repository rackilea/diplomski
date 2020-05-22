Map<String, AtomicLong> map = new ConcurrentHashMap<>();
collection.forEach(s -> map.computeIfAbsent(s, __ -> new AtomicLong()).incrementAndGet());
boolean containsAll = map.isEmpty() || stream.map(Object::toString)
                                             .filter(map::containsKey)
                                             .filter(s -> map.get(s).decrementAndGet() == 0)
                                             .filter(s -> map.remove(s) != null)
                                             .anyMatch(__ -> map.isEmpty());