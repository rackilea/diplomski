Collection<Callable<String>> tasks = elements.stream()
    .map(element -> new Callable<String>() {
        public String call() throws ContractException, TimeoutException, InterruptedException {
            byte[] result = contract.submitTransaction("someFunction", element);
            return new String(result);
        }
    }).collect(Collectors.toList());

try {
    Collection<String> results = new ArrayList<>();

    Collection<Future<String>> futures = executor.invokeAll(tasks, timeout, timeUnit);
    for (Future<String> future : futures) {
        try {
            String result = future.get(timeout, timeUnit);
            results.add(result);
        } catch (CancellationException | InterruptedException | ExecutionException | TimeoutException e) {
            e.printStackTrace();
        }
    }

    System.out.println("Results: " + results);
} catch (InterruptedException e ) {
    e.printStackTrace();
}