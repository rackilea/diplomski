@Override
public Map<String, Object> More ...getMap() {
if (map == null) {
 map = new HashMap<String, Object>();
 Iterator<ViewRow> itr = iterator();

  while(itr.hasNext()) {
  ViewRow cur = itr.next();
  map.put(cur.getId(), cur.getDocument());
  }
}
return Collections.unmodifiableMap(map);
}