Map<String, Integer> map = new HashMap<>();
String key = "A Key";
Integer value = 1;
map.put(key, value);

Object objectKey = key; // this is the same key object, but it is typed as Object
map.containsKey(objectKey); // what would you want/expect this to return?
map.get(objectKey); // ...or this?