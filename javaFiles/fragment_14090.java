ExecutorService executor = Executors.newCachedThreadPool();

    // ... set up builder as before ...
    Future<Response> responseFuture = executor.submit(
            () -> builder.post(Entity.json(new Gson().toJson(request))));
    try {
        Response response = responseFuture.get(timeout, TimeUnit.SECONDS);
        // return normal response here
    } catch (TimeoutException ex) {
        executor.submit( () -> {
            Response lateResponse = responseFuture.get();
            // send overThreshold alert email here
            // Dummy return - prefer Callable to Runnable here for exception handling
            return null;
        } );
        // return a message to user here saying their payment could not be processed
    }