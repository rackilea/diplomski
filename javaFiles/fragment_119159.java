// for calling directly
public static <E> E alwaysThrow(E k1, E k2) {
    // by the way, k1 is not the key, see https://stackoverflow.com/a/45210944/2711488
    throw new IllegalArgumentException("Duplicate key " + k1 + " not allowed!");
}
// when needing a shared BinaryOperator
public static <E> BinaryOperator<E> throwingMerger() {
    return ContainingClass::alwaysThrow;
}