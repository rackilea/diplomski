ArrayList<Integer> entry = map.get(key);
if (entry == null) {
  entry = new ArrayList<Integer>();
  map.put(key, entry);
}
entry.add(index);