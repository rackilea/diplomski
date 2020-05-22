@Test
public void testMapCollector() {

    Set<Key> keySet = new HashSet<>();
    keySet.add(new Key("key1"));
    keySet.add(new Key("key2"));
    keySet.add(new Key("key3"));

    Map<Key, List<Value>> map = keySet.stream().collect(
            Collectors.toMap(k -> k, key -> new ArrayList<>()));

    System.out.println(map);

}

class Key {
    String key;

    public Key(String value) {
        this.key = value;
    }

    @Override
    public String toString() {
        return "Key [key=" + key + "]";
    }
}

class Value {
}