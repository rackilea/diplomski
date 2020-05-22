/**
 * @author ruslan.lopez
 */
public class CyclomaticVsHash {

    private static final Random RNG    = new Random();
    static int[]                myHash = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11,
            12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28,
            29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40 };

    /**
     * @param args
     *            the command line arguments
     */
    public static void main(String[] args) {
        long iterations = 100000000;
        warmUp(iterations);
        System.out.println("Cycle1");
        double individualTime = getAverageTimePerIterationc1(iterations);
        iterations = 10000;
        double totalTime = getTotalTimec1(iterations);

        System.out.println("ns/iteration: " + individualTime);
        System.out.println("Total time for " + iterations + " runs: "
                           + totalTime);

        System.out.println("Cycle2");
        iterations = 100000000;
        warmUp(iterations);
        double individualTime1 = getAverageTimePerIterationc2(iterations);
        iterations = 10000;
        double totalTime1 = getTotalTimec2(iterations);

        System.out.println("ns/iteration: " + individualTime1);
        System.out.println("Total time for " + iterations + " runs: "
                           + totalTime1);

    }

    public static void warmUp(long iterations) {
        System.out.println("Starting warmup");
        for (int i = 0; i < iterations; i++) {
            runCycles();
            runCycles1();
        }
    }

    public static double getAverageTimePerIterationc1(long iterations) {
        // test
        System.out.println("Starting individual time test");
        long timeTaken = 0;
        for (int i = 0; i < iterations; i++) {
            long startTime = System.nanoTime();
            runCycles();
            timeTaken += System.nanoTime() - startTime;
        }
        return (double) timeTaken / iterations;
    }

    public static long getTotalTimec1(long iterations) {
        // test
        System.out.println("Starting total time test");
        long timeTaken = 0;
        for (int i = 0; i < iterations; i++) {
            long startTime = System.nanoTime();
            runCycles();
            timeTaken += System.nanoTime() - startTime;
        }
        return timeTaken;
    }

    public static double getAverageTimePerIterationc2(long iterations) {
        // test
        System.out.println("Starting individual time test");
        long timeTaken = 0;
        for (int i = 0; i < iterations; i++) {
            long startTime = System.nanoTime();
            runCycles1();
            timeTaken += System.nanoTime() - startTime;
        }
        return (double) timeTaken / iterations;
    }

    public static long getTotalTimec2(long iterations) {
        // test
        System.out.println("Starting total time test");
        long timeTaken = 0;
        for (int i = 0; i < iterations; i++) {
            long startTime = System.nanoTime();
            runCycles1();
            timeTaken += System.nanoTime() - startTime;
        }
        return timeTaken;
    }

    private static void runCycles() {
        Integer num = RNG.nextInt();
        int newnum;
        switch (num) {
            case 1:
                newnum = num * 1;
                break;
            case 2:
                newnum = num * 2;
                break;
            case 3:
                newnum = num * 3;
                break;
            case 4:
                newnum = num * 4;
                break;
            case 5:
                newnum = num * 5;
                break;
            case 6:
                newnum = num * 6;
                break;
            case 7:
                newnum = num * 7;
                break;
            case 8:
                newnum = num * 8;
                break;
            case 9:
                newnum = num * 9;
                break;
            case 10:
                newnum = num * 10;
                break;
            case 11:
                newnum = num * 11;
                break;
            case 12:
                newnum = num * 12;
                break;
            case 13:
                newnum = num * 13;
                break;
            case 14:
                newnum = num * 14;
                break;
            case 15:
                newnum = num * 15;
                break;
            case 16:
                newnum = num * 16;
                break;
            case 17:
                newnum = num * 17;
                break;
            case 18:
                newnum = num * 18;
                break;
            case 19:
                newnum = num * 19;
                break;
            case 20:
                newnum = num * 20;
                break;
            case 21:
                newnum = num * 21;
                break;
            case 22:
                newnum = num * 22;
                break;
            case 23:
                newnum = num * 23;
                break;
            case 24:
                newnum = num * 24;
                break;
            case 25:
                newnum = num * 25;
                break;
            case 26:
                newnum = num * 26;
                break;
            case 27:
                newnum = num * 7;
                break;
            case 28:
                newnum = num * 28;
                break;
            case 29:
                newnum = num * 29;
                break;
            case 30:
                newnum = num * 30;
                break;
            case 31:
                newnum = num * 31;
                break;
            case 32:
                newnum = num * 32;
                break;
            case 33:
                newnum = num * 33;
                break;
            case 34:
                newnum = num * 34;
                break;
            case 35:
                newnum = num * 35;
                break;
            case 36:
                newnum = num * 36;
                break;
            case 37:
                newnum = num * 37;
                break;
            case 38:
                newnum = num * 38;
                break;
            case 39:
                newnum = num * 39;
                break;
            default:
                newnum = num * 40;
                break;
        }
    }

    private static void runCycles1() {
        Integer num = RNG.nextInt();
        int nwenum = num > 0 && num < 39
                                        ? myHash[num - 1]
                                        : myHash[39];
    }
}