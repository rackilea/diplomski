public class MethodQueueSimulator {
    Collection<Callable<Void>> methodQueue = new LinkedList<>();
    ExecutorService executor = Executors.newSingleThreadExecutor();

    public static void main(String args[]) throws InterruptedException {

        MethodQueueSimulator simulator = new MethodQueueSimulator();

        simulator.QueueSimulation(new Callable<Void>() {
            @Override
            public Void call() throws Exception {
                System.out.println("1");
                return null;
            }
        });

        // if using java 8+, you can use lambdas instead
        simulator.QueueSimulation(() -> {
            System.out.println("2");
            return null;
        });

        simulator.QueueSimulation(() -> {
            System.out.println("3");
            return null;
        });

        System.out.println("Simulation starts");

        simulator.RunSimulation();

        System.out.println("Simulation complete");
    }

    public void QueueSimulation(Callable<Void> method){
        methodQueue.add(method);
    }

    public void RunSimulation() throws InterruptedException {
        executor.invokeAll(methodQueue);
        // must call shutdown, else process will not exit
        executor.shutdown();
    }
}