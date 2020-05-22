public Map<String, Object> myMethod() { 
  List someList = ...;
  int someInt = ....;
  ...
  Map<String, Object> map = new HashMap<String, Object>();
  map.put("list", someList);
  map.put("count", someInt);
  return map;
}