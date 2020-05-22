int ringBufferSize = Optional.ofNullable(System.getProperty("rx.ring-buffer.size"))
    .map(Integer::parseInt)
    .orElse(128);
logItemPublisher
    .buffer(
            loggingProperties.getBufferTimeoutMillis(),
            TimeUnit.MILLISECONDS,
            loggingProperties.getBufferSize(),
            logDispatchScheduler
    )
    .onBackpressureDrop(droppedLogsHandler)
    .observeOn(logDispatchScheduler, ringBufferSize)
    .flatMap(logs -> persist(logs, url))
    .subscribe();