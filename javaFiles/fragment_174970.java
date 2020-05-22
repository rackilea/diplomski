public Map<String, List<A>> findCommonEntries(List<List<A>> aListList) {
    Map<String, List<A>> aMap = new HashMap<>();

    for (List<A> aList : aListList) {
        for (A a : aList) {
            if (!aMap.containsKey(a.getX()))
                aMap.put(a.getX(), new ArrayList<>());

            aMap.get(a.getX()).add(a);
        }
    }
}