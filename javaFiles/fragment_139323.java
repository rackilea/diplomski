public static void main(String[] args) {
  CompletableFuture.runAsync(
          () -> {
            try {
              read(data);
            } catch (IOException ex) {
              throw new UncheckedIOException(ex);
            }
          })
      .orTimeout(1L, TimeUnit.SECONDS)
      .join();
}