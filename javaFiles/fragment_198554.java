public class FirstDoneWithCompletableFutureEx {

    public static void main(String[] args) throws ExecutionException, InterruptedException {

        int jobs = 10;
        CompletableFuture<?>[] futures = new CompletableFuture[jobs];
        for (int i = 0; i < jobs; i++) {
            futures[i] = CompletableFuture.supplyAsync(() -> {
                //computation    
                return new Object();
            });
        }

        //first job done
        Object firstDone = CompletableFuture.anyOf(futures).get();
    }
}