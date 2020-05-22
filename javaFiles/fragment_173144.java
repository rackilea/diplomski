private static class Range {
   public int upper, value;
   ...
}

NavigableMap<Integer, Range> map = new TreeMap<Integer, Range>();
map.put(0, new Range(3, 0));       // 0..3     => 0
map.put(5, new Range(10, 1));      // 5..10    => 1
map.put(100, new Range(200, 2));   // 100..200 => 2

// To do a lookup for some value in 'key'
Map.Entry<Integer,Range> entry = map.floorEntry(key);
if (entry == null) {
    // too small
} else if (key <= entry.getValue().upper) {
    return entry.getValue().value;
} else {
    // too large or in a hole
}