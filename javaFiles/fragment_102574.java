ExecutorService executor = Executors.newFixedThreadPool(Runtime
            .getRuntime().availableProcessors());
    List<Callable<Boolean>> callables = new ArrayList<>();
    for (int counter = 0; counter < 8; counter++) {
        callables.add(new MyCallable());
    }

    List<Future<Boolean>> futures = executor.invokeAll(callables);
    for (Future<Boolean> future : futures) {
        System.out.println(future.get()); // You'd want to store this into an array or wherever you see fit.
    }

    executor.shutdown();