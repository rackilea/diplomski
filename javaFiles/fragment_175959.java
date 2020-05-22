public static void main(String[] args) {
    Map<Integer, Float> unsortFloatMap = new HashMap<Integer, Float>();
    unsortFloatMap.put(1985, 0.54660827f);
    unsortFloatMap.put(2002, 0.45290402f);
    unsortFloatMap.put(1993, 0.40605184f);
    unsortFloatMap.put(2015, 0.3591997f);

    unsortFloatMap.put(1975, 0.0f);
    unsortFloatMap.put(1997, 0.031234723f);
    unsortFloatMap.put(2004, 0.046852008f);
    unsortFloatMap.put(2005, 0.1093216f);
    unsortFloatMap.put(2003, 0.29673007f);
    unsortFloatMap.put(1998, 0.29673007f);
    unsortFloatMap.put(2007, 0.31234753f);
    unsortFloatMap.put(1995, 0.73401666f);

    System.out.println("Unsort Float Map......");
    printMap(unsortFloatMap);

    System.out.println("Sorted Float Map......");
    Map<Integer, Float> sortedFloatMap = sortByFloatValue(unsortFloatMap);
    printMap(sortedFloatMap);
}

// pretty print a map
public static <K, V> void printMap(Map<K, V> map) {
    for (Map.Entry<K, V> entry : map.entrySet()) {
        System.out.println("Key : " + entry.getKey() + " Value : " + entry.getValue());
    }
}

private static Map<Integer, Float> sortByFloatValue(Map<Integer, Float> unsortMap) {
    List<Map.Entry<Integer, Float>> list = new LinkedList<Map.Entry<Integer, Float>>(unsortMap.entrySet());
    Collections.sort(list, new Comparator<Map.Entry<Integer, Float>>() {
        public int compare(Map.Entry<Integer, Float> o1, Map.Entry<Integer, Float> o2) {
            return (o1.getValue()).compareTo(o2.getValue());
        }
    });

    /// Loop the sorted list and put it into a new insertion order Map
    /// LinkedHashMap
    Map<Integer, Float> sortedMap = new LinkedHashMap<Integer, Float>();
    for (Map.Entry<Integer, Float> entry : list) {
        sortedMap.put(entry.getKey(), entry.getValue());
    }

    return sortedMap;
}