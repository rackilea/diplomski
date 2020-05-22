char c = s1.indexAt(i);
if(map.contains(c)) {
  map.put(c, map.get(c)++);
}else {
  map.put(c,1);
}