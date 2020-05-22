public static <K extends Comparable<? super K>, V>
    Map<K, Boolean> compareKeysAndValues(final Map<K, V> map1,
        final Map<K, V> map2){
        final Collection<K> allKeys = new HashSet<K>();
        allKeys.addAll(map1.keySet());
        allKeys.addAll(map2.keySet());
        final Map<K, Boolean> result = new TreeMap<K, Boolean>();
        for(final K key : allKeys){
            result.put(key,
                map1.containsKey(key) == map2.containsKey(key) &&
                Boolean.valueOf(equal(map1.get(key), map2.get(key))));
        }
        return result;
    }