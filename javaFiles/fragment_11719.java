@Test
public void storeDataInMapWithCompositeKey() {
    Map<Key, Integer> myMap = new HashMap<>();
    myMap.put(new Key(0,0,0), 0);
    myMap.put(new Key(0,0,1), 1);
}