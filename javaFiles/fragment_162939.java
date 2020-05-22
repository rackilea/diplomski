public static TreeSet<Rate> intersect(List<TreeSet<Rate>> setList) {
    if (setList.isEmpty()) {
        throw new IllegalArgumentException("Need at least one TreeSet in list");
    }
    Iterator<TreeSet<Rate>> it = setList.iterator();
    TreeSet<Rate> result = new TreeSet<>(it.next());
    while (it.hasNext()) {
        result.retainAll(it.next());
    }
    return result;
}