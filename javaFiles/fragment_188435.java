String res;
synchronized (features) {
  if(!features.containsKey(id)) {
    features.put(id, id);
  }
  res = features.get(id);
}