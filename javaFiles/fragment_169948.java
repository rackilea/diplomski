HashMap<Integer, String> hashMap = new HashMap<>();
hashMap.put(1, "test1");
hashMap.put(2, "test2");
hashMap.put(3, "test3");

// use this
Map<Integer, String> yourNewHashMap = hashMap.entrySet().stream()
                                       .filter(es -> es.getKey() != 1) // make sure index 1 is omitted
                                       .map(es -> new AbstractMap.SimpleEntry<Integer, String>(es.getKey() - 1, es.getValue())) // decrease the index for each key/value pair
                                       .collect(Collectors.toMap(AbstractMap.SimpleEntry::getKey, AbstractMap.SimpleEntry::getValue)); // create a new map