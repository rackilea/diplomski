public static void main(String[] args) {
    Set<Integer> mySetA = get(Arrays.asList("1"));
    // test(mySetA);
}

private static <T> Set<T> get(Object b) {
    Set<T> a = new HashSet<T>(cast(b));
    return a;
}

public static <T> T cast(Object object) {
    return (T) object;
}