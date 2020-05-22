public class MyTask extends Task<Integer> {
    int iterations;
    Random random = new Random();
    ProgressReporter reporter = new ProgressReporter();

    public MyTask(int iterations) {
        this.iterations = iterations;
    }

    @Override
    protected Integer call() throws Exception {
        // Simply divide work load to each thread
        int workers = 8;
        int limit = iterations /workers;
        int rem = iterations % workers;

        // add a property listener for progress update
        reporter.addPropertyChangeListener(new PropertyChangeListener() {
            @Override
            public void propertyChange(PropertyChangeEvent evt) {
                updateProgress((int) evt.getNewValue(), iterations);
            }
        });

        // Creates a executor
        ExecutorService executorService = Executors.newCachedThreadPool();
        for (int i = 0; i < workers; i++) {
            int start = limit * i;
            int end = limit * (i + 1);
            if (i == workers - 1) end += rem;

            Counter counter = new Counter(i ,start, end, random.nextInt(1000), reporter);
            executorService.submit(counter); // Submit work to be done
        }

        executorService.shutdown(); // shutdown executor not to accept any more threads
        while (!executorService.isTerminated()){
            if (isCancelled()){
                executorService.shutdownNow(); // stop all the processes immediately
            }
        }

        return reporter.getProgress();
    }
}