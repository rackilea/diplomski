@SuppressWarnings("unchecked")
@SafeVarargs
public static <T> Collector<T, ?, Map<?, ?>> multiGrouping(
                                                Function<? super T, ?>... classifiers) {
    Collector<T, ?, Map<?, ?>> result = null;
    for(int i=classifiers.length-1; i>=0; i--) {
        Collector<?, ?, ?> next;
        if(result == null) {
            next = Collectors.groupingBy(classifiers[i]);
        } else {
            next = Collectors.groupingBy(classifiers[i], result);
        }
        result = (Collector<T, ?, Map<?, ?>>)next;
    }
    return result;
}