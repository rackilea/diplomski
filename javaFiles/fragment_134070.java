Map<String, List<String>> map = new HashMap<>();
List<String> initialList = new ArrayList<>();
initialList.add("v");
initialList.add("foo");
initialList.add("bar");
map.put("v3", initialList);

// add some new String      
map.get("v3").add("Some_new_string");

// adding a whole new list
map.get("v3").addAll(Arrays.asList("new_element_1", "new_element_2"));