new Random().ints(100).boxed()
        .parallel()
        .map(this::slowOperation)
        .collect(Collectors.toList())
        // Start new stream here
        .stream()
        .map(Function.identity())//some fast operation, but must be in single thread
        .collect(Collectors.toSet());