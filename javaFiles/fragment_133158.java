Object existing = concurrentMap.get(key);
// check if this key is already present
if (existing == null) {
  Object newObject = new Object();
  existing = concurrentMap.putIfAbsent(key, newObject); // atomic operation
  // another thread might have already stored mapping for key
  if (existing == null) {
    return newObject;
  }
}
return existing;