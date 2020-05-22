NavigableMap<Integer, Integer> map = new TreeMap<Integer, Integer>();
map.put(0, 0);    // 0..4     => 0
map.put(5, 1);    // 5..10    => 1
map.put(11, 2);   // 11..200  => 2

// To do a lookup for some value in 'key'
if (key < 0 || key > 200) {
    // out of range
} else {
   return map.floorEntry(key).getValue();
}