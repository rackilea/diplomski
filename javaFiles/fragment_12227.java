public List<List<Integer>> chopped(List<Integer> list, final int splitCount) {
    List<List<Integer>> parts = new ArrayList<>(splitCount);
    for (int i = 0; i < splitCount; ++i) {
        parts.add(new ArrayList<>());
    }
    final int N = list.size();
    for (int i = 0; i < N; ++i) {
        parts.get(i % splitCount).add(list.get(i));
    }
    return parts;
}