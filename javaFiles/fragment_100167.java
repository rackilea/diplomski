public void stuff() {

    CompletableFuture<?> c = new CompletableFuture<String>();

    complete(c,"bla");

  }

  private static <T> void complete(CompletableFuture<?> c, T value) {
    ((CompletableFuture<T>) c).complete(value);
  }