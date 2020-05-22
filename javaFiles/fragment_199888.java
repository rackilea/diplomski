Map<String, Integer> myMap = new HashMap<>();
...
    Integer count = myMap.get(key);
    if (count == null){
        myMap.put(key, 1);
    } else {
        myMap.put(key, count + 1);
    }