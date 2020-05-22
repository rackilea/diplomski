public class Test {

    private static final int THREADS = 10;
    private static final int DATA_SIZE = 1000;

    public static void main(String[] args) {
        // Declare a new ExecutorService with a maximum of 2 threads.
        ExecutorService service = Executors.newFixedThreadPool(THREADS);

        // Prepare a list of Future results.
        List<Future<String>> futures = new ArrayList<Future<String>>(DATA_SIZE);

        // Submit the tasks and store the results.
        for (int i = 0; i < DATA_SIZE; i++) {
            futures.add(service.submit(new StringTask("Sample String " + i)));
        }

        // Accept no new tasks.
        service.shutdown();

        // Retrieve the actual String results.
        List<String> results = new ArrayList<String>(DATA_SIZE);
        try {
            for (Future<String> future : futures) {
                // The get() method blocks if the execution of the task is not finished.
                results.add(future.get());
                System.out.println(future.get());
            }
        } catch (ExecutionException ee) {
            System.out.println("Error while getting result!");
            ee.printStackTrace();
        } catch (InterruptedException ie) {
            System.out.println("Error while getting result!");
            ie.printStackTrace();
        }
    }

    /**
     * Callable task that reverses a given String.
     */
    private static final class StringTask implements Callable<String> {
        private String input;

        private StringTask(String input) {
            super();

            if (input == null) {
                throw new NullPointerException();
            }

            this.input = input;
        }

        @Override
        public String call() throws Exception {
            StringBuilder builder = new StringBuilder();

            for (int i = this.input.length() - 1; i >= 0; i--) {
                builder.append(this.input.charAt(i));
            }

            return builder.toString();
        }
    }
}