ForkJoinPool forkJoinPool = new ForkJoinPool(4); // Typically set it to Runtime.availableProcessors()
uberlist = forkJoinPool.submit(() -> {
     return map.entrySet().stream()
                             .parallel()  // Use .stream().parallel() to force parallism. The .parallelStream() does not guarantee that the returned stream is parallel stream
                             .filter(yourCondition)
                             .map(e -> yourService.methodCall(e))
                             .collect(Collectors.toList());
}).get();