static <T> List<T> trim3(List<T> list, Predicate<T> isEmpty) {
    Collection<T> ltrimreverse = list.stream().dropWhile(isEmpty)
        .collect(ArrayDeque::new, ArrayDeque::push, ArrayDeque::addAll);
    Collection<T> rtrim = ltrimreverse.stream().dropWhile(isEmpty)
        .collect(ArrayDeque::new, ArrayDeque::push, ArrayDeque::addAll);
    return new ArrayList<>(rtrim);
}