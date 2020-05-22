public class ResultCalculator {
    private final ExecutorService pool;
    private final List<Future<Integer>> pendingResults;

    public ResultCalculator(ExecutorService pool) {
        this.pool = pool;
        this.pendingResults = new ArrayList<Future<Integer>>();
    }

    public void startComputation() {
        for (int i = 0; i < 5; i++) {
            Future<Integer> future = pool.submit(new Robot(i));
            pendingResults.add(future);
        }
    }

    public int getFinalResult() throws ExecutionException {
        int total = 0;
        for (Future<Integer> robotResult : pendingResults) {
            total += robotResult.get();
        }
        return total;
    }
}

public class Robot implements Callable<Integer> {
    private final int input;

    public Robot(int input) {
        this.input = input;
    }

    @Override
    public Integer call() {
        // Some very long calculation
        Thread.sleep(10000);

        return input * input;
    }
}