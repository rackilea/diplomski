public List<Map.Entry<String, Integer> sortMap(Map<String, Integer> map) {
    List<Map.Entry<String, Integer> elements = new LinkedList<>(map.entrySet());
    Collections.sort(elements, new Comparator<Map.Entry<String, Integer>>() {

        public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2 ) {
            return o1.getValue().compareTo(o2.getValue());
        }

    });
}