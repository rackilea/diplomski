public <T> Set<T> find(Class<T> clz, Filter criteria) {
  List<?> raw = session.find(clz, criteria); /* A legacy, un-generic API. */
  Set<T> safe = new HashSet<T>();
  for (Object o : raw) 
    safe.add(clz.cast(o));
  return safe;
}