public void kickOffAsyncTasks(int execCount) throws InterruptedException {
  Collection<Future<String>> results = new ArrayList<>(execCount);

  //kick off all threads
  for (int idx = 0; idx < execCount; idx++) {
    results.add(asyncTask.call());
  }

  // wait for all threads
  results.forEach(result -> {
    try {
      result.get();
    } catch (InterruptedException | ExecutionException e) {
      //handle thread error
    }
  });

  //all threads finished
}