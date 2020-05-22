public static int[] flatten(Object[] array) {
    return Arrays.stream(array)
                 .filter(Objects::nonNull)
                 .flatMapToInt(a -> {
                    if (a instanceof Object[]) return Arrays.stream(flatten((Object[]) a));
                    return Arrays.stream((int[]) a);
                 })
                 .toArray();
}