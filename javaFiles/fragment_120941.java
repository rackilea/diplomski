// initialise the executor
    ScheduledExecutorService executor = Executors.newSingleThreadScheduledExecutor();

    while (tasksRemaining) {
        // create your task
        Runnable task = ....;
        // submit it to the executor, using one of the various scheduleXYZ methods
        executor.schedule(task, delay, unit);
    }

    // when everything is finished, shutdown the executor
    executor.shutdown();