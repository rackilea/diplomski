Map<K,V> map = 
List<Map.Entry<K,V>> list = new ArrayList<Map.Entry<K,V>>(map.entrySet());

// each time you want a different order.
Collections.shuffle(list);
for(Map.Entry<K, V> entry: list) { /* ... */ }