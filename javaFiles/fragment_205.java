@Test
public void treeMapSortedByValue() {
    // given the following map:
    TreeMap<Integer, Double> map = new TreeMap<Integer, Double>();
    map.put(2, Math.E);
    map.put(1, Math.PI);
    map.put(3, 42.0);

    // build a TreeSet of entries
    Set<Map.Entry<Integer, Double>> sortedEntries = new TreeSet<Map.Entry<Integer, Double>>(new DoubleComparator());
    sortedEntries.addAll(map.entrySet());

    // optionally you can build a List<Double> with the sorted 
    List<Double> doubles = new LinkedList<Double>();
    for (Map.Entry<Integer, Double> entry : sortedEntries) {
        doubles.add(entry.getValue());
    }
}