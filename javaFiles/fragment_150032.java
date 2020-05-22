TreeMap<String, Object> map = new TreeMap<String, Object>();

map.put("baz", new Object());
map.put("foo", new Object());
map.put("fooz", new Object());
map.put("fo", new Object());

Map.Entry<String, Object> test = map.ceilingEntry("fo");
bool containsSubStringKey = test != null && test.getKey().startsWith("fo");