MultiMap map = new MultiHashMap();    
String[] elements = source.split(",");

// process the elements in groups of four
for (int keyIndex = 0; keyIndex < elements.length; keyIndex += 4) {
  String key = elements[keyIndex];
  map.put(key, elements[keyIndex+1]);
  map.put(key, elements[keyIndex+2]);
  map.put(key, elements[keyIndex+3]);
}