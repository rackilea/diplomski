public class Workflow {

    private final ExecutorService executor;
    private final Phaser phaser;

    public Workflow(ExecutorService executor, Phaser phaser) {
        this.executor = executor;
        this.phaser = phaser;
    }

    public void execute(int request) throws InterruptedException, ExecutionException {
        executor.submit(() -> {
            phaser.register();
            // Data collection
            Future<Integer> input = executor.submit(() -> {
                phaser.register();
                System.out.println("Gathering data for call " + request);
                phaser.arrive();
                return request;
            });
            // Data Processing
            Future<Integer> result = executor.submit(() -> {
                phaser.register();
                System.out.println("Processing call " + request);
                Thread.sleep(5000);
                phaser.arrive();
                return request;
            });
            // Post processing
            Future<Integer> ack = executor.submit(() -> {
                phaser.register();
                System.out.println("Notyfing processors for call " + request);
                phaser.arrive();
                return request;
            });
            final Integer output = ack.get();
            phaser.arrive();
            return output;
        });
    }

}