public static <T> List<T> join(List<? extends T> first, List<? extends T> second) {
    List<T> joined = new ArrayList<>();
    joined.addAll(first);
    joined.addAll(second);
    return joined;
}