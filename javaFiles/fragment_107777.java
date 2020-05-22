return ForkJoinTask.invokeAll(createSubtasks())
    .parallelStream()
    .map(ForkJoinTask::join)
    .flatMap(map -> map.entrySet().stream())   // you were missing this line
    .collect(
        Collectors.toConcurrentMap(entry -> entry.getKey(), entry -> entry.getValue())
    );