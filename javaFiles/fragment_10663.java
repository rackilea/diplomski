@Test
public void concurrentTransactionsAreIsolated() throws Exception {
  CyclicBarrier barrier = new CyclicBarrier(2);
  Runnable sync = uncheckedRunnable(() -> barrier.await(1, TimeUnit.SECONDS));

  jdbi.useTransaction(handle -> insert(handle, 1, 1));

  CompletableFuture<Void> first = CompletableFuture.runAsync(uncheckedRunnable(() -> {
    jdbi.useTransaction(tx -> {
      assertThat(tx.isInTransaction()).isTrue();
      assertThat(tx.getTransactionIsolationLevel()).isEqualTo(TransactionIsolationLevel.SERIALIZABLE);

      log.info("first tx started");
      sync.run(); // wait for both transactions to start

      insert(tx, 2, 2);

      log.info("first tx inserted row");
      sync.run(); // let the second txn check uncommitted reads
      sync.run(); // wait for second txn to check the uncommitted reads
    });

    log.info("first tx committed");
    sync.run(); // transaction closed, let second transaction check committed reads
  }));

  CompletableFuture<Integer> subject = CompletableFuture.supplyAsync(uncheckedSupplier(() -> {
    int out = jdbi.inTransaction(tx -> {
      assertThat(tx.isInTransaction()).isTrue();
      assertThat(tx.getTransactionIsolationLevel()).isEqualTo(TransactionIsolationLevel.SERIALIZABLE);

      log.info("second tx started");
      sync.run(); // wait for both transactions to start
      sync.run(); // wait for first txn to insert

      log.info("second tx checking uncommitted read");
      assertThat(count(tx)).isEqualTo(1);

      sync.run(); // let the first txn commit
      sync.run(); // wait for first txn to commit

      log.info("second tx checking committed read");
      return count(tx);
    });
    log.info("second tx committed");

    return out;
  }));

  // capture exceptions from either thread
  CompletableFuture.allOf(first, subject).get();

  assertThat(subject.get()).isEqualTo(1);
}