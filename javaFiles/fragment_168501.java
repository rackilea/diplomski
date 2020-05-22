public static <K, V> void changeSetToList (Map<K, Set<V>> givenMap, 
        Map<K, List<V>> newMap) {

    for (K str: givenMap.keySet()) {
        newMap.put(str, new ArrayList<V>(givenMap.get(str)));
    }

    for(K str:newMap.keySet()) {
        System.out.println(newMap.get(str));
    }
}