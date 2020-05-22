@FunctionalInterface
public interface IntTernaryOperator {
    int applyAsInt(int a, int b, int c);
}

public static int operate1(
    int a, int b,
    IntBinaryOperator op
) {
    return op.applyAsInt(a, b);
}

public static int operate2(
    int a, int b, int c,
    IntTernaryOperator op
) {
    return op.applyAsInt(a, b, c);
}