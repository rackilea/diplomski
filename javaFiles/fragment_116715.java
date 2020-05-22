public static <T> ListenableFuture<List<T>> allOf(final List<? extends ListenableFuture<? extends T>> futures) {
    // we will return this ListenableFuture, and modify it from within callbacks on each input future
    final SettableListenableFuture<List<T>> groupFuture = new SettableListenableFuture<>();

    // use a defensive shallow copy of the futures list, to avoid errors that could be caused by
    // someone inserting/removing a future from `futures` list after they call this method
    final List<? extends ListenableFuture<? extends T>> futuresCopy = new ArrayList<>(futures);

    // Count the number of completed futures with an AtomicInt (to avoid race conditions)
    final AtomicInteger resultCount = new AtomicInteger(0);
    for (int i = 0; i < futuresCopy.size(); i++) {
        futuresCopy.get(i).addCallback(new ListenableFutureCallback<T>() {
            @Override
            public void onSuccess(final T result) {
                int thisCount = resultCount.incrementAndGet();

                // if this is the last result, build the ArrayList and complete the GroupFuture
                if (thisCount == futuresCopy.size()) {
                   List<T> resultList = new ArrayList<T>(futuresCopy.size());
                    try {
                        for (ListenableFuture<? extends T> future : futuresCopy) {
                            resultList.add(future.get());
                        }
                        groupFuture.set(resultList);
                    } catch (Exception e) {
                        // this should never happen, but future.get() forces us to deal with this exception.
                        groupFuture.setException(e);
                    }
                }
            }

            @Override
            public void onFailure(final Throwable throwable) {
                groupFuture.setException(throwable);

                // if one future fails, don't waste effort on the others
                for (ListenableFuture future : futuresCopy) {
                    future.cancel(true);
                }
            }
        });
    }

    return groupFuture;
}