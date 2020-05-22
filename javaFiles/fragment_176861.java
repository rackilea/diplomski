ExecutorService exec = Executors.newFixedThreadPool(SOME_NUM_OF_THREADS);
try {
    for (final Object o : list) {
        exec.submit(new Runnable() {
            @Override
            public void run() {
                // do stuff with o.
            }
        });
    }
} finally {
    exec.shutdown();
}