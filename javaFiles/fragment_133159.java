Object value = concurrentMap.get(key);
if (value == null) {
  synchronized (lock) {
    value = concurrentMap.get(key);
    if (value == null) {
      value = new Object();
      concurrentMap.put(key, value);
    }
  }
}
return value;