public Map<Class, Object> doSomeStuff(){
  Map<Class, Object> map = HashMap<Class, Object>();
  map.put(String.getClass(), "This is an example");
  map.put(Object.getClass(), new Object());
  //...
  return map;
}

// You can then retrieve all results by
String stringVal = map.get(String.getClass());
Object objectVal = map.get(Object.getClass());