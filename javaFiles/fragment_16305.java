import java.util.stream.LongStream;

public class Collatz {
    static final short[] CALC_CACHE = new short[Integer.MAX_VALUE-8];

    public static int calculate(long c) {
        if (c == 1) {
            return 0;
        }
        int steps;
        if (c < CALC_CACHE.length) {
            steps = CALC_CACHE[(int) c];
            if (steps > 0)
                return steps;
        }
        if (c % 2 == 0) {
            steps = calculate(c / 2) + 1;
        } else {
            steps = calculate((c * 3 + 1) / 2) + 2;
        }
        if (c < CALC_CACHE.length) {
            if (steps > Short.MAX_VALUE)
                throw new AssertionError();
            CALC_CACHE[(int) c] = (short) steps;
        }
        return steps;
    }

    static int calculate2(long n) {
        int numSteps = 0;
        long c = n;
        while (c != 1) {
            if (c < CALC_CACHE.length) {
                int steps = CALC_CACHE[(int) c];
                if (steps > 0) {
                    numSteps += steps;
                    break;
                }
            }
            if (c % 2 == 0) {
                numSteps++;
                c /= 2;
            } else {
                numSteps += 2;
                if (c > Long.MAX_VALUE / 3)
                    throw new IllegalStateException("c is too large " + c);
                c = (c * 3 + 1) / 2;
            }
        }
        if (n < CALC_CACHE.length) {
            CALC_CACHE[(int) n] = (short) numSteps;
        }
        return numSteps;
    }

    public static void main(String args[]) {
        long maxN = 0, maxSteps = 0;
        long startTime = System.currentTimeMillis();
        long[] res = LongStream.range(1, 6_000_000_000L).parallel().collect(
                () -> new long[2],
                (long[] arr, long n) -> {
                    int steps = calculate(n);
                    if (steps > arr[0]) {
                        arr[0] = steps;
                        arr[1] = n;
                    }
                },
                (a, b) -> {
                    if (a[0] < b[0]) {
                        a[0] = b[0];
                        a[1] = b[1];
                    }
                });
        maxN = res[1];
        maxSteps = res[0];
        long time = System.currentTimeMillis() - startTime;
        System.out.printf("After %.3f seconds, maxSteps: %,d for: %,d%n", time / 1e3, maxSteps, maxN);
    }
}