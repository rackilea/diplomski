import java.util.Arrays;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class MixedParallel
{
    // pre-requisite: sorted values !!
    private static final int[] data = new int[] { 5, 10, 20, 25, 40, 50 };

    // Context to store intermediate computation or a solution
    static class Context {
        int k;
        int sum;
        int[] coeff;
        Context(int k, int sum, int[] coeff) {
            this.k = k;
            this.sum = sum;
            this.coeff = coeff;
        }
    }

    // Thread pool for parallel execution
    private static ExecutorService executor;
    // Queue to collect solutions
    private static Queue<Context> solutions;

    static {
        final int numberOfThreads = 2;
        executor =
            new ThreadPoolExecutor(numberOfThreads, numberOfThreads, 1000, TimeUnit.SECONDS,
                                   new LinkedBlockingDeque<Runnable>());
        // concurrent because of multi-threaded insertions
        solutions = new ConcurrentLinkedQueue<Context>();
    }


    public static void main(String[] args)
    {
        int target_sum = 100;
        // result vector, init to 0
        int[] coeff = new int[data.length];
        Arrays.fill(coeff, 0);
        mixedPartialSum(data.length - 1, target_sum, coeff);

        executor.shutdown();
        // System.out.println("Over. Dumping results");
        while(!solutions.isEmpty()) {
            Context s = solutions.poll();
            printResult(s.coeff);
        }
    }

    private static void printResult(int[] coeff) {
        StringBuffer sb = new StringBuffer();
        for (int i = coeff.length - 1; i >= 0; i--) {
            if (coeff[i] > 0) {
                sb.append(data[i]).append(" * ").append(coeff[i]).append("   ");
            }
        }
        System.out.println(sb.append("from ").append(Thread.currentThread()));
    }

    private static void mixedPartialSum(int k, int sum, int[] coeff) {
        int x_k = data[k];
        for (int c = sum / x_k; c >= 0; c--) {
            coeff[k] = c;
            int[] newcoeff = Arrays.copyOf(coeff, coeff.length);
            if (c * x_k == sum) {
                //printResult(newcoeff);
                solutions.add(new Context(0, 0, newcoeff));
                continue;
            } else if (k > 0) {
                if (data.length - k < 2) {
                    mixedPartialSum(k - 1, sum - c * x_k, newcoeff);
                    // for loop on "c" goes on with previous coeff content
                } else {
                    // no longer recursive. delegate to thread pool
                    executor.submit(new ComputePartialSum(new Context(k - 1, sum - c * x_k, newcoeff)));
                }
            }
        }
    }

    static class ComputePartialSum implements Callable<Void> {
        // queue with contexts to process
        private Queue<Context> contexts;

        ComputePartialSum(Context request) {
            contexts = new ArrayDeque<Context>();
            contexts.add(request);
        }

        public Void call() {
            while(!contexts.isEmpty()) {
                Context current = contexts.poll();
                int x_k = data[current.k];
                for (int c = current.sum / x_k; c >= 0; c--) {
                    current.coeff[current.k] = c;
                    int[] newcoeff = Arrays.copyOf(current.coeff, current.coeff.length);
                    if (c * x_k == current.sum) {
                        //printResult(newcoeff);
                        solutions.add(new Context(0, 0, newcoeff));
                        continue;
                    } else if (current.k > 0) {
                        contexts.add(new Context(current.k - 1, current.sum - c * x_k, newcoeff));
                    }
                }
            }
            return null;
        }
    }
}