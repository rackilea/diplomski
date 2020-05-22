List<Map<String,Comparable>> listMap = ...
Collections.sort(listMap, new Comparator<Map<String, Comparable>> () {

    @Override
    public int compare(Map<String, Comparable> m1, Map<String, Comparable> m2) {
        return m2.get("full_inc").compareTo(m1.get("full_inc")); //descending
    }
});