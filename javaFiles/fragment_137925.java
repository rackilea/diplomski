public Map<Dog, Cat> pair(Map<Key, Dog> indexedDogs, Map<Key, Cat> indexedCats) {
    Set<Key> commonKey = indexedDogs.keySet();
    commonKey.retainAll(indexedCats.keySet());

    Map<Dog, Cat> map = new HashMap<>();

    for (Key key: commonKey) {
        map.put(indexedDogs.get(key), indexedCats.get(key));
    }

    return map; 
}