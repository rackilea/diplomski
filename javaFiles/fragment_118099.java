public Comparator<Map<String, String>> mapComparator = new Comparator<Map<String, String>>() {
    public int compare(Map<String, String> m1, Map<String, String> m2) {
        return m1.get("name").compareTo(m2.get("name"));
    }
}

Collections.sort(list, mapComparator);