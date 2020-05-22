private List<ResultSetFuture> runningInsertList;
private static int concurrentInsertLimit = 1000;
private static int concurrentInsertSleepTime = 500;
...

@Override
public void executeBatch(Statement statement) throws InterruptedException {
    if (this.runningInsertList == null) {
        this.runningInsertList = new ArrayList<>();
    }

    ResultSetFuture future = this.executeAsync(statement);
    this.runningInsertList.add(future);

    Futures.addCallback(future, new FutureCallback<ResultSet>() {
        @Override
        public void onSuccess(ResultSet result) {
            runningInsertList.remove(future);
        }

        @Override
        public void onFailure(Throwable t) {
            runningInsertList.remove(future);
            concurrentInsertErrorOccured = true;
        }
    }, MoreExecutors.sameThreadExecutor());

    //Sleep while the currently processing number of inserts is too high
    while (runningInsertList.size() >= concurrentInsertLimit) {
        Thread.sleep(concurrentInsertSleepTime);
    }

    if (!concurrentInsertErrorOccured) {
        // Increase your ingestion rate if no query failed so far
        concurrentInsertLimit += 10;
    } else {
        // Decrease your ingestion rate because at least one query failed
        concurrentInsertErrorOccured = false;
        concurrentInsertLimit = Max(1, concurrentInsertLimit - 50);
        while (runningInsertList.size() >= concurrentInsertLimit) {
            Thread.sleep(concurrentInsertSleepTime);
        }
    }

    return;
}