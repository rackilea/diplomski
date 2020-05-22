public static Set<HashMap<String, Integer>> myTree = new TreeSet<>(
                new Comparator<HashMap<String, Integer>>() {
                    @Override
                    public int compare(HashMap<String, Integer> o1,
                            HashMap<String, Integer> o2) {
                        return (o2.get(key)).compareTo(o1.get(key));
        }
});