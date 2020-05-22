@SafeVarargs
public static <T> List<T> list(T... t) {
    return Collections.unmodifiableList(
        new ArrayList<>(Arrays.asList(t))
    );
}