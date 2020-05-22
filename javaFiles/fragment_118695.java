Foo value = map.get(key);
if (value != null) {
    ...
} else {
    // Key might be present...
    if (map.containsKey(key)) {
       // Okay, there's a key but the value is null
    } else {
       // Definitely no such key
    }
}