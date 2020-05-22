public class ExampleExecutor {

    private final Executor executor;
    private long submitCount = 0;
    private long doneCount = 0;

    public ExampleExecutor(Executor executor) {
        this.executor = executor;
    }

    public synchronized void execute(Collection<Runnable> commands) {
        for (Runnable command : commands) {
            execute(command);
        }
    }

    public synchronized void execute(final Runnable command) {
        submitCount ++;

        executor.execute(new Runnable() {
            public void run() {
                try {
                    command.run();
                } finally {
                    synchronized (ExampleExecutor.this) {
                        doneCount++;
                        if (doneCount == submitCount) {
                            ExampleExecutor.this.notifyAll();
                        }
                    }
                }
            }
        });
    }

    public synchronized void awaitCompletion() throws InterruptedException {
        while (doneCount != submitCount) {
            this.wait();
        }
    }
}