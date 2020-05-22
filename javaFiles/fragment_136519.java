ExecutorService executor = Executors.newSingleThreadExecutor();

    // LAMBDA COMPILED INTO A 'Callable<?>'
    executor.submit(() -> {
        while (true)
            throw new Exception();
    });

    // LAMBDA COMPILED INTO A 'Runnable': EXCEPTIONS MUST BE HANDLED BY LAMBDA ITSELF!
    executor.submit(() -> {
        boolean value = true;
        while (value)
            throw new Exception();
    });