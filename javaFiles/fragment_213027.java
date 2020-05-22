Map myMap = ...;
myMap.put("foo", null);
if (myMap.containsKey("foo")) {
   Object value = myMap.get(key); // value is null
}

Object value = myMap.get("foo");
if (value != null) {
    // you won't get here
}