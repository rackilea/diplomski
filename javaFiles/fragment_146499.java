static <T> List<Integer> indexOfAll(T obj, List<T> list) {
    final List<Integer> indexList = new ArrayList<>();
    for (int i = 0; i < list.size(); i++) {
        if (obj.equals(list.get(i))) {
            indexList.add(i);
        }
    }
    return indexList;
}