String outerKey = "exampleKey1";
String innerKey = "exampleKey2";
SomeClass innerValue = new SomeClass();

TreeMap<String, SomeClass> innerMap = myMap.get(outerKey);
if (innerMap == null) {
  innerMap = Collections.synchronizedMap(new TreeMap<String, SomeClass>());
  myMap.put(outerKey, innerMap);
}
innerMap.put(innerKey, innerValue);