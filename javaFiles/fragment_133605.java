Map map1 = new HashMap();
map1 = Collections.unmodifiableMap(map1);
Map map2 = new HashMap();
Map map3 = new HashMap(map1);
Set s1 = map1.keySet();
Set s2 = map2.keySet();
Set s3 = map3.keySet();
s3.retainAll(s2);