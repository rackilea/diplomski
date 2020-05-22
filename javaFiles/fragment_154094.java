private Map<String, AtomicLong> ids = new ConcurrentHashMap<>();
ids.putIfAbsent(mapKey, new AtomicLong());
AtomicLong idForKey = ids.get(mapKey);
// Optionally, those two lines can be shorted to:
//   ids.computeIfAbsent(mapKey, k -> new AtomicLong())

long newId = generateId(mapKey);
long origId = idForKey.get();
if (newId > origId && idForKey.compareAndSet(origId, newId)) {
   return newId;
} else {
   // do something else
}