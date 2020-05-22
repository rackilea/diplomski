public static <T, K> Iterator<Entry<T, K>> pairs(List<T> l1, List<K> l2) {
    return IntStream.range(0, l1.size())
            .mapToObj(i -> IntStream.range(l1 == l2 ? i + 1 : 0, l2.size())
                    .mapToObj(j -> new Entry<>(l1.get(i), l2.get(j))))
            .flatMap(Function.identity())
            .iterator();
}