List<Object> al = map.get(key);
if (al == null) {
  al = new ArrayList<Object>();
  map.put(key, al);
}
al.add(value);