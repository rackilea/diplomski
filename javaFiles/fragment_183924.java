Map<String, String> map = new HashMap<>();
map.add("New York".toLowerCase() ,"New York");
map.containsKey("new york".toLowerCase()) == true;
map.containsKey("NEW YORK".toLowerCase()) == true;

map.values().each(it -> print it) ---> prints "New York"