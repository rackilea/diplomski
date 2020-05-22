for (Field f : obj.getClass().getDeclaredFields()) {
  f.setAccessible(true); // optional
  if (f.get(obj) == null) {
     f.set(obj, getDefaultValueForType(f.getType()));
     // OR throw error
  }
}