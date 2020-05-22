public static LinkedHashMap<String, Author> sortName(Map<String, Author> unSortedMap) {
    List<Map.Entry<String, Author>> list = new ArrayList<Map.Entry<String, Author>>(unSortedMap.entrySet());

    Collections.sort(list, new Comparator<Map.Entry<String, Author>>() {
        public int compare(Map.Entry<String, Author> a, Map.Entry<String, Author> b) {
            return a.getValue().name.compareTo(b.getValue().name);
        }
    });

    LinkedHashMap<String, Author> result = new LinkedHashMap<String, Author>();
    for (Entry<String, Author> entry : list) {
        result.put(entry.getKey(), entry.getValue());
    }

    return result;
}