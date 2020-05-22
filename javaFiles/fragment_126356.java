class HashMapWithLowestValueCached<K, V extends Comparable> extends HashMap<K, V> {    
    V lowestValue;
    K lowestValueKey;    
    void put(K k, V v) {
      if (v.compareTo(lowestValue) < 0) {
        lowestValue = v; 
        lowestValueKey = k;
      }
      super.put(k, v);
    }
    K lowestValueKey () { return lowestValueKey; }
}