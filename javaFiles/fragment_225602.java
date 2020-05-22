ExecutorService executor = new ThreadPoolExecutor(1, 10, 60, TimeUnit.SECONDS, new LinkedBlockingDeque<Runnable>()) {
    @Override
    public <T> Future<T> submit(final Callable<T> task) {
        Callable<T> wrappedTask = new Callable<T>() {
            @Override
            public T call() throws Exception {
                try {
                    return task.call();
                }
                catch (Exception e) {
                    System.out.println("Oh boy, something broke!");
                    e.printStackTrace();
                    throw e;
                }
            }
        };

        return super.submit(wrappedTask);
    }
};