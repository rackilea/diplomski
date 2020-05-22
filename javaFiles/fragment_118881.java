Iterator<Map.Entry<K,V>> iter = map1.entrySet().iterator();
while (iter.hasNext()) {
  Map.Entry<K,V> entry = iter.next();
  if(not map2 contain k){
    iter.remove();
  } else {
    entry.put new data
  }
}