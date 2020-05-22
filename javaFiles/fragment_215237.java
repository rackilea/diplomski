List<ListenableFuture<T>> originalFutures = ...;
List<ListenableFuture<T>> defaultAfterTimeoutFutures = new ArrayList<>();
for (ListenableFuture<T> f : originalFutures) {
  f = Futures.withTimeout(f, 50, MILLISECONDS, executor);
  f = Futures.withFallback(f, ...);
  defaultAfterTimeoutFutures.add(f);
}
result = Futures.allAsList(defaultAfterTimeoutFutures).get();