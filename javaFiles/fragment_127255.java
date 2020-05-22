public MultiKeyMap<K1, K2, V> {

private HashMap<Object, V> map;

public MultiKeyMap(){
    map = new HashMap<Object, V>();
}

public void put(Object key, V v){
    map.put(key, v);
}

public void get(Object key, V v){
    return map.get(key);
}

public void put(K1 k1, K2 k2, V v){
    if(!map.containsKey(k1) && !map.containsKey(k2)) {
        map.put(k1, v);
        map.put(k2, v);
    }
}