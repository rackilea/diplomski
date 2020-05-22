HashMap<Integer, String> hashMap = new HashMap<>();
hashMap.put(1, "test1");
hashMap.put(2, "test2");
hashMap.put(3, "test3");

Map<Integer, String> yourNewHashMap = new HashMap<>();
for (final Map.Entry<Integer, String> entry : hashMap.entrySet()) {
    if (entry.getKey() != 1) { // make sure index 1 is omitted
        yourNewHashMap.put(entry.getKey() - 1, entry.getValue()); // decrease the index for each key/value pair and add it to the new map
    }
}