import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicLong;

public class Main {
    public static final int TOP_LEVELS = 2;

    enum BuySell {}

    private static final AtomicLong called = new AtomicLong();

    public static void main(String... args) throws InterruptedException {
        int maxLevels = 15;
        long start = System.nanoTime();
        method(maxLevels);
        long time = System.nanoTime() - start;
        System.out.printf("Took %.3f second to navigate %,d levels called %,d times%n", time / 1e9, maxLevels, called.longValue());
    }

    public static void method(int maxLevels) throws InterruptedException {
        ExecutorService service = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());
        try {
            int result = method(service, 0, maxLevels - 1, new int[maxLevels]).call();
        } catch (Exception e) {
            e.printStackTrace();
        }
        service.shutdown();
        service.awaitTermination(10, TimeUnit.MINUTES);
    }

    // single threaded process the highest levels of the tree.
    private static Callable<Integer> method(final ExecutorService service, final int level, final int maxLevel, final int[] options) {
        int choices = level % 2 == 0 ? 3 : 4;
        final List<Callable<Integer>> callables = new ArrayList<Callable<Integer>>(choices);
        for (int i = 0; i < choices; i++) {
            options[level] = i;
            Callable<Integer> callable = level < TOP_LEVELS ?
                    method(service, level + 1, maxLevel, options) :
                    method1(service, level + 1, maxLevel, options);
            callables.add(callable);
        }
        return new Callable<Integer>() {
            @Override
            public Integer call() throws Exception {
                Integer min = Integer.MAX_VALUE;
                for (Callable<Integer> result : callables) {
                    Integer num = result.call();
                    if (min > num)
                        min = num;
                }
                return min;
            }
        };
    }

    // at this level, process the branches in separate threads.
    private static Callable<Integer> method1(final ExecutorService service, final int level, final int maxLevel, final int[] options) {
        int choices = level % 2 == 0 ? 3 : 4;
        final List<Future<Integer>> futures = new ArrayList<Future<Integer>>(choices);
        for (int i = 0; i < choices; i++) {
            options[level] = i;
            final int[] optionsCopy = options.clone();
            Future<Integer> future = service.submit(new Callable<Integer>() {
                @Override
                public Integer call() {
                    return method2(level + 1, maxLevel, optionsCopy);
                }
            });
            futures.add(future);
        }
        return new Callable<Integer>() {
            @Override
            public Integer call() throws Exception {
                Integer min = Integer.MAX_VALUE;
                for (Future<Integer> result : futures) {
                    Integer num = result.get();
                    if (min > num)
                        min = num;
                }
                return min;
            }
        };
    }

    // at these levels each task processes in its own thread.
    private static int method2(int level, int maxLevel, int[] options) {
        if (level == maxLevel) {
            return process(options);
        }
        int choices = level % 2 == 0 ? 3 : 4;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < choices; i++) {
            options[level] = i;
            int n = method2(level + 1, maxLevel, options);
            if (min > n)
                min = n;
        }

        return min;
    }

    private static int process(final int[] options) {
        int min = options[0];
        for (int i : options)
            if (min > i)
                min = i;
        called.incrementAndGet();
        return min;
    }
}