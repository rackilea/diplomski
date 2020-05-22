try {
    final Future<List<String>> future = mWorkerThread.execute(() ->
            mRepository.softDeleteAllInTransaction(tasks));
    mMainThread.post(() -> {
        try {
            callback.onDeleteSuccess(future.get()); // LINE 1
        } catch (InterruptedException | ExecutionException e) {
            Timber.e(e);
            throw new RuntimeException(e.getCause()); // LINE 2
        }
    });