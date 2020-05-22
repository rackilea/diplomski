Map<String, List<String>> myMap = new HashMap<>();

List<String> myList = new ArrayList<>();
myList.add("Test 1");
myList.add("Test 2");
myList.add("Test 3");
myMap.put("Tests", myList);

myMap.get("Tests").add("Test 4");