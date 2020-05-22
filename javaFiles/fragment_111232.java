NavigableMap<Integer, Date> datesMap = new TreeMap<>();
...
// Get only the 20 first entries
Map<Integer, Date> subMap = datesMap.subMap(0, 20);
...
// Get only the next 20 entries
Map<Integer, Date> nextSubMap = datesMap.subMap(20, 40);