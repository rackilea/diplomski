public static class CalculationJob implements Callable<Integer> {
    int input;

    public CalculationJob(int input) {
        this.input = input;
    }

    @Override
    public Integer call() throws Exception {
        return input + 1;
    }
}

public static void main(String[] args) throws InterruptedException {
    ExecutorService executorService = Executors.newFixedThreadPool(4);

    Future<Integer> result = executorService.submit(new CalculationJob(3));

    try {
        Integer integer = result.get(10, TimeUnit.MILLISECONDS);
        System.out.println("result: " + integer);
    } catch (Exception e) {
        // interrupts if there is any possible error
        result.cancel(true);
    }

    executorService.shutdown();
    executorService.awaitTermination(1, TimeUnit.SECONDS);
}