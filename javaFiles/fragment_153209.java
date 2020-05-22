private final int F1 = 542;
private final int F2 = 323;

public final static int mul0(int a, int b) {
    if (a == 1) {
        return b;
    }
    return mul0(a - 1, b) + b;
}

//O(log n)
public final static int mul2(int a, int b) {
    if (a == 1) {
        return b;
    }

    int sum = ((a & 1) == 1) ? b : 0;

    return mul2(a / 2, b + b) + sum;
}

@Benchmark
public int test0() {
    return mul0(F1, F2);
}

@Benchmark
public int test2() {
    return mul2(F1, F2);
}