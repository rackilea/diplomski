public class FutureTest {
    public static void main(String[] args) throws IOException {
        doSomethingSlowly()
                .timeout(1, TimeUnit.SECONDS, Observable.just("timeout"))
                .subscribe(System.out::println);
        System.in.read(); // keep process alive
    }

    private static Observable<String> doSomethingSlowly() {
        CompletableFuture<String> future = CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
            }
            return "Something";

        });
        return toObservable(future);
    }

    private static <T> Observable<T> toObservable(CompletableFuture<T> future) {
        return Observable.create(subscriber -> {
            subscriber.add(new Subscription() {
                private boolean unsubscribed = false;
                @Override
                public void unsubscribe() {
                    if (!future.isDone()){
                        future.cancel(true);
                    }
                    unsubscribed = true;
                }

                @Override
                public boolean isUnsubscribed() {
                    return unsubscribed;
                }
            });

            future.thenAccept(value -> {
                if (!subscriber.isUnsubscribed()){
                    subscriber.onNext(value);
                    subscriber.onCompleted();
                }
            }).exceptionally(throwable -> {
                if (!subscriber.isUnsubscribed()) {
                    subscriber.onError(throwable);
                }
                return null;
            });
        });
    }
}