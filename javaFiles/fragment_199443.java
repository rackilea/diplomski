ExecutorService ex = Executors.newCachedThreadPool();
    ExecutorCompletionService<Boolean> cs = new ExecutorCompletionService<Boolean>(
            ex);
    List<Callable<Boolean>> tasks = new ArrayList<Callable<Boolean>>();
       ... add tasks
    List<Future<Boolean>> futures = new ArrayList<Future<Boolean>>();
    for (Callable<Boolean> t : tasks) {
        futures.add(cs.submit(t));
    }
    for (!futures.isEmpty()) {
        try {
            Future<Boolean> f = cs.poll(1, TimeUnit.SECONDS);
            futures.remove(f);  // poll returns the same instance of Future as in the futures list
            if (f == null || !f.get()) {  // poll returns null on timeout
                break;
            }
        } catch (Exception e) {
            break;
        }
    }
    // cancel remaining tasks, if all finished OK the list will be empty
    for (Future<Boolean> future : futures) {
        future.cancel(true);
    }