Set<Future<Double>> futures = new HashSet<>(tasks.keySet());
Set<Future<Double>> failures = new LinkedHashSet<>();

while (!futures.isEmpty()) {
    try {
        Future<Double> future = completionService.take();
        int n = tasks.get(future); //original value of n
        double squareRoot = future.get(); //result of task
        System.out.printf("The square root of %d is %f%n", n, squareRoot);
    }
    catch (ExecutionException e) {
        Integer n = tasks.get(future); //original value of n
        System.err.printf("Failure to obtain square root of %d: %s%n", n, e.getMessage());
        failures.add(future);
    }
    catch (InterruptedException e) {
        //TODO: handle interruption somehow, perhaps logging partial results?
    }
    finally {
        futures.remove(future);
    }
}

if(!failures.isEmpty()) {
    //TODO you may want to do do something about the failures you got
}