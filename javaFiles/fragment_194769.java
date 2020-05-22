public static <K, V extends MyObject> 
              HashMap<K, V> CloneHashMap (HashMap<K, V> input) {
    HashMap<K, V> output = new HashMap<K, V>();
    for(K key: input.keySet()) {
        output.put(key, (V)(input.get(key).clone()));           
    }
    return output;
}