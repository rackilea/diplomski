private static List<Throwable> collectedExceptions = Collections.synchronizedList(new ArrayList<>());

public static void main(String[] args) throws ExecutionException, InterruptedException {

    CompletableFuture<Void> process1 = CompletableFuture.runAsync(() -> {
        System.out.println("Process 1 with exception");
        throw new RuntimeException("Exception 1");
    }).exceptionally(exception -> {
        // Handle your exception here
        collectedExceptions.add(exception);
        return null;
    });

    CompletableFuture<Void> process2 = CompletableFuture.runAsync(() -> {
        System.out.println("Process 2 without exception");
    });

    CompletableFuture<Void> process3 = CompletableFuture.runAsync(() -> {
        System.out.println("Process 3 with exception");
        throw new RuntimeException("Exception 3");
    }).exceptionally(exception -> {
        // Handle your exception here
        collectedExceptions.add(exception);
        return null;
    });

    CompletableFuture<Void> allOfProcesses = CompletableFuture.allOf(process1, process2, process3);

    allOfProcesses.get();
    assert (collectedExceptions.size() == 2);
}