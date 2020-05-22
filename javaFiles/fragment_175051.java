Future<Double> future = completionService.take();
try {
    System.out.printf("The square root of %d is %f%n", tasks.get(future), future.get());
}
catch (ExecutionException e) {
    if(e.getCause() != null && e.getCause() instanceof InvalidIntegerException) {
        Integer n = ((InvalidIntegerException) e.getCause()).getInteger();
        System.err.println("Failure to calculate the square root of: " + n);
    }