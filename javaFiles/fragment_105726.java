private List<List<Integer>> copy(List<List<Integer>> toCopy) {
    List<List<Integer>> copy = new ArrayList<>(toCopy.size());
    for(List<Integer> inner : toCopy) {
        copy.add(new ArrayList<Integer>(inner));
    }
    return copy;
}