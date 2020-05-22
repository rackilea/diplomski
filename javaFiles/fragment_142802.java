public class Main {

    private static final int NUM_TESTS = 100;
    private static int ITERATIONS = 1000000;
    // time counters
    private static long inTime = 0L;
    private static long aroundTime = 0L;

    public static void main(String[] args) {
        for (int i = 0; i < NUM_TESTS; i++) {
            test();
            ITERATIONS += 1; // so the tests don't always return the same number
        }
        System.out.println("Inside loop: " + (inTime/1000000.0) + " ms.");
        System.out.println("Around loop: " + (aroundTime/1000000.0) + " ms.");
    }
    public static void test() {
        aroundTime += testAround();
        inTime += testIn();
    }
    public static long testIn() {
        long start = System.nanoTime();
        Integer i = tryInLoop();
        long ret = System.nanoTime() - start;
        System.out.println(i); // don't optimize it away
        return ret;
    }
    public static long testAround() {
        long start = System.nanoTime();
        Integer i = tryAroundLoop();
        long ret = System.nanoTime() - start;
        System.out.println(i); // don't optimize it away
        return ret;
    }
    public static Integer tryInLoop() {
        int count = 0;
        for (int i = 0; i < ITERATIONS; i++) {
            try {
                count = Integer.parseInt(Integer.toString(count)) + 1;
            } catch (NumberFormatException ex) {
                return null;
            }
        }
        return count;
    }
    public static Integer tryAroundLoop() {
        int count = 0;
        try {
            for (int i = 0; i < ITERATIONS; i++) {
                count = Integer.parseInt(Integer.toString(count)) + 1;
            }
            return count;
        } catch (NumberFormatException ex) {
            return null;
        }
    }
}