public static CompletableFuture<Integer> apiCall(int id) {
  return CompletableFuture.supplyAsync(() -> {
    if (id == 0) throw new RuntimeException("Please not 0!!");
    else return id;
  });
}