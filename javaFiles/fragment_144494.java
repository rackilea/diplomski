List<String> upperLines = lines.stream()
    .map(String::toUpperCase)
    .peek(line -> CompletableFuture.runAsync(() -> System.out.println(line)))
    .collect(Collectors.toList());
// when running this in the main method, avoid JVM termination before the async jobs:
ForkJoinPool.commonPool().awaitQuiescence(1, TimeUnit.DAYS);