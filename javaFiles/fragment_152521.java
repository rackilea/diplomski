public class Test {

    static class Task implements Runnable {
        private final String id;
        private final long repetitions;
        private final long respawnSize;
        private final ExampleExecutor executor;

        public Task(String id, long repetitions, long respawnSize, ExampleExecutor executor) {
            this.id = id;
            this.repetitions = repetitions;
            this.respawnSize = respawnSize;
            this.executor = executor;
        }

        public void run() {
            for (int i = 0; i < respawnSize; i ++) {
                // Spawning new sub tasks
                executor.execute(new Task(id + "-" + i, repetitions/2, 0, null));
            }

            double sum = 0;
            for (int i = 0; i < repetitions; i++) {
                sum += Math.sin(i);
            }

            System.err.println(id + " completed at " + System.currentTimeMillis() + " with sum=" + sum);
        }
    }

    public static void main(String argv[]) throws InterruptedException {
        ExampleExecutor executor = new ExampleExecutor(Executors.newFixedThreadPool(2));
        executor.execute(new Task("0", 2000000, 100, executor));

        System.err.println("main thread awaits completion");
        executor.awaitCompletion();
        System.err.println("main thread recieved completion event");
    }
}