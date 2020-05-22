public class Collatz {
    static final int[] CALC_CACHE = new int[2_000_000_000];

    static int calculate(long n) {
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
            CALC_CACHE[(int) n] = numSteps;
        }
        return numSteps;
    }

    public static void main(String args[]) {
        long n = 1, maxN = 0, maxSteps = 0;
        long startTime = System.currentTimeMillis();
        while (System.currentTimeMillis() < startTime + 60000) {
            for (int i = 0; i < 10; i++) {
                int steps = calculate(n);
                if (steps > maxSteps) {
                    maxSteps = steps;
                    maxN = n;
                }
                n++;
            }
            if (n % 10000000 == 1)
                System.out.printf("%,d%n", n);
        }
        System.out.printf("The highest number was: %,d, maxSteps: %,d for: %,d%n", n, maxSteps, maxN);
    }
}