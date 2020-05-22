public static void main(String[] args) {
    String[] strings = {"One", "One", "One", "Two", "Three", "Three"};

    //Count occurences
    Map<String, Integer> map = new HashMap<String, Integer>();

    for (String s : strings) {
        if (map.containsKey(s)) {
            map.put(s, map.get(s) + 1);
        } else {
            map.put(s, 1);
        }
    }

    ValueComparator<String, Integer> comparator = new ValueComparator<String, Integer> (map);
    Map<String, Integer> sortedMap = new TreeMap<String, Integer> (comparator);
    sortedMap.putAll(map);

    List<String> sortedList = new ArrayList<String> (sortedMap.keySet());

    System.out.println(sortedMap);
    System.out.println(sortedList);

}

static class ValueComparator<K, V extends Comparable<V>> implements Comparator<K> {

    Map<K, V> map;

    public ValueComparator(Map<K, V> base) {
        this.map = base;
    }

    @Override
    public int compare(K o1, K o2) {
         return map.get(o2).compareTo(map.get(o1));
    }
}