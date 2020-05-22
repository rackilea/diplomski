Map<String,Object> map = new HasMap<String,Object>();
// ... insert stuff into map
// eg: map.add("something", new MyObject());

String key = "something";
if (map.contains(key)) {
    Object o = map.get(key);
}