public static List<List<X>> asList(X[][] x) {
    List<X[]> list = Arrays.asList(x);
    List<List<X>> newList = new ArrayList<List<X>>(list.size());
    for (X[] xArray : list) {
        newList.add(Arrays.asList(xArray));
    }
    return list;
}