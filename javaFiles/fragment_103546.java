LOG.info("Time limited task started on monitored thread, with limit (" + limit + ")");
    final ZonedDateTime start = nowUTC();
    final Thread thread = new Thread(toRun);
    thread.setDaemon(true);
    final List<Throwable> exceptions = new ArrayList<>();
    thread.setUncaughtExceptionHandler((t, e) -> {
        exceptions.add(e);
    });
    thread.start();

    // Check and wait for completion.
    while (thread.isAlive()) {
        if (!isWithinLimit(start, nowUTC())) {
            LOG.error("Interrupting thread, did not complete before limit (" + limit + ")");
            try {
                thread.interrupt();
            } catch (Exception e) {
                e.printStackTrace();
            }
            throw new TimeLimitExceedException("Execution limit of " + limit
                    + " exceeded. (Has been running since " + start + ")");
        }
        try {
            Thread.sleep(POLLING_PERIOD.toMillis());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    // If it failed because of an exception, we want to trigger this.
    if (!exceptions.isEmpty()) {
        final Throwable exception = exceptions.get(0);
        if (exception instanceof RuntimeException) {
            throw (RuntimeException) exception;
        } else {
            throw new RuntimeException(exception);
        }
    }
    final Duration runTime = Duration.between(start, nowUTC());
    LOG.info("Time limited task has completed in (" + runTime + ") vs limit of (" + limit
            + ").");