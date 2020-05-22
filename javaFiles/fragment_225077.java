//Java7 Diamond Notation
Map<ArrayList, Map<String, Integer>> nestedMap = new HashMap<>();

//get nested map 
Map<String, Integer> innerMap = nestedMap.get(some_key_value_string);

//now get the Integer value from the innerMap
Integer innerMapValue = innerMap.get(some_key_value_string);