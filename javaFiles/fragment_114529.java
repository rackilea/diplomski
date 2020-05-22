public static Set<Entry<Integer, Integer>> fillMap(int[] a, int[] b) {
    HashMap<Integer, Integer> entries = new HashMap<>();    
    for (Integer i : a) 
        entries.put(i, entries.get(i) == null ? 1 : entries.get(i) + 1);

    for (Integer i : b) 
        entries.put(i, entries.get(i) == null ? 1 : entries.get(i) + 1);

    return entries.entrySet();
}