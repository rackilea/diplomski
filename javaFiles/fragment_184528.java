Create ThreadPoolExecutor and ExecutorCompletionService wrapping it

while (true) {
  int freeThreads = executor.getMaximumPoolSize() - executor.getActiveCount()
  fetch 'freeThreads' tasks and submit to completion service (which
                                      in turn sends it to executor)

  wait until completion service reports finished task (with timeout)
}