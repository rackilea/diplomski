ExecutorService executor = Executors.newFixedThreadPool(3);
ExecutorCompletionService<Double> completionService = new ExecutorCompletionService<>(executor);

completionService.submit(() -> doTaskWith(100));
completionService.submit(() -> doTaskWith(200));

Future<Double> future = completionService.take(); //whichever finishes first