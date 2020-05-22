while (true) {
  RecentUpdates old = map.get(key);
  RecentUpdates updated = update(old); // copy
  if((old == null) 
      ? map.putIfAbsent(key, value) == null 
      : map.replace(key, old, value)) {
    return updated;
  }
}