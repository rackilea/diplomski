static Optional<Integer> firstInt(Object o) {
    if (o instanceof Integer)
        return Optional.of((Integer) o);
    if (o instanceof int[]) {
        int[] array = (int[]) o;
        return array.length > 0 ? Optional.of(array[0]) : Optional.empty();
    }
    if (o instanceof Object[])
        return firstInt(Arrays.asList((Object[]) o));
    if (o instanceof Iterable) {
        for (Object o2 : (Iterable<?>) o) {
            Optional<Integer> result = firstInt(o2);
            if (result.isPresent())
                return result;
        }
    }
    return Optional.empty();
}