public static void run(Service callableService) {
    try {
        Future<Callable> future = executor.submit(callableService);
        run(future.get().restart()); // <=== will block until task completes!
    } catch (InterruptedException | ExcecutionException e) {
        // Program will shutdown
    }
}