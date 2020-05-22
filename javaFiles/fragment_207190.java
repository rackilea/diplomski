private static void sortUsingTreeMap(Map<String, Integer> map) {
    TreeMap<String, Integer> sorted = new TreeMap<String, Integer>(new MyComparator(map));
    sorted.putAll(map);
    System.out.println(sorted);
}

static class MyComparator implements Comparator<String> {
    private Map<String, Integer> map;

    MyComparator(Map<String, Integer> map) {
        this.map = map;
    }

    @Override
    public int compare(String o1, String o2) {
        return map.get(o1).compareTo(map.get(o2));
    }
}
--> output: {one=1, two=2, three=3}