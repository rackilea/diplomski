private static <K> void sumMaps(Map<K, Integer> a, Map<K, Integer> b) {
        for (K key : b.keySet()) {
            Integer currentCount = a.get(key);
            a.put(key, currentCount == null ? b.get(key) : currentCount + b.get(key));
        }
    }