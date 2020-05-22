NavigableMap<Double, String> myMap = new TreeMap<>();

//...

for (Map.Entry<Double, String> e : myMap.entrySet()) {
    Map.Entry<Double, String> next = myMap.higherEntry(e.getKey()); // next
    Map.Entry<Double, String> prev = myMap.lowerEntry(e.getKey());  // previous

   // do work with next and prev
}