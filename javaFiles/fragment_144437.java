import java.awt.Point;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class OriginalParallel
{
    static final int numberOfThreads = 2;
    static final int maxRecursionDepth = 3;

    public static void main(String[] args)
    {
        int target_sum = 100;
        int[] data = new int[] { 50, 40, 25, 20, 10, 5 };
        List T = tableGeneator(target_sum, data);
        int[] coeff = new int[data.length];
        Arrays.fill(coeff, 0);
        RecursivelyListAllThatWork(data.length, target_sum, T, coeff, data);
        executor.shutdown();
    }

    private static void printResult(int[] coeff, int[] data) {
        StringBuffer sb = new StringBuffer();
        for (int i = coeff.length - 1; i >= 0; i--) {
            if (coeff[i] > 0) {
                sb.append(data[i]).append(" * ").append(coeff[i]).append("   ");
            }
        }
        System.out.println(sb.append("from ").append(Thread.currentThread()));
    }

    // Thread pool for parallel execution
    private static ExecutorService executor;
    static {
        executor =
            new ThreadPoolExecutor(numberOfThreads, numberOfThreads, 1000, TimeUnit.SECONDS,
                                   new LinkedBlockingDeque<Runnable>());
    }

    private static void RecursivelyListAllThatWork(int k, int sum, List T, int[] coeff, int[] data) {
        if (k == 0) {
            printResult(coeff, data);
            return;
        }
        Integer x_k = data[k-1];
        //  Recursive step: Try all coefficients, but only if they work. 
        for (int c = 0; c <= sum/x_k; c++) { //the c variable caps the percent
            if (T.contains(new Point((sum - c * x_k), (k-1)))) {
                    // mark the coefficient of x_k to be c
                    coeff[k-1] = c;
                    if (data.length - k != maxRecursionDepth) {
                        RecursivelyListAllThatWork((k - 1), (sum - c * x_k), T, coeff, data);
                    } else {
                        // delegate to thread pool when reaching depth 3
                        int[] newcoeff = Arrays.copyOf(coeff, coeff.length);
                        executor.submit(new RecursiveThread(k - 1, sum - c * x_k, T, newcoeff, data)); 
                    }
                    // unmark the coefficient of x_k
                    coeff[k-1] = 0;
            }
        }
    }

    static class RecursiveThread implements Callable<Void> {
        int k;
        int sum;
        int[] coeff;
        int[] data;
        List T;

        RecursiveThread(int k, int sum, List T, int[] coeff, int[] data) {
            this.k = k;
            this.sum = sum;
            this.T = T;
            this.coeff = coeff;
            this.data = data;
            System.out.println("New job for k=" + k);
        }

        public Void call() {
            RecursivelyListAllThatWork(k, sum, T, coeff, data);
            return null;
        }
    }

    public static List tableGeneator(int target_sum, int[] data) {
        List T = new ArrayList();
        T.add(new Point(0, 0));

        float max_percent = 1;
        int R = (int) (target_sum * max_percent * data.length);
        for (int i = 0; i < data.length; i++) {
            for (int s = -R; s < R + 1; s++) {
                int max_value = (int) Math.abs((target_sum * max_percent) / data[i]);
                for (int c = 0; c < max_value + 1; c++) {
                    if (T.contains(new Point(s - c * data[i], i))) {
                        Point p = new Point(s, i + 1);
                        if (!T.contains(p)) {
                            T.add(p);
                        }
                    }
                }
            }
        }
        return T;
    }
}