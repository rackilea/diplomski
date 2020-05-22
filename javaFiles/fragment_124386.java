private static final ExecutorService workers = Executors.newCachedThreadPool();

...

Collection<Callable<User>> tasks = new ArrayList<Callable<User>>();
for (final String id : ids) {
  tasks.add(new Callable<User>()
  {

    public User call()
      throws Exception
    {
      return svc.getUser(id);
    }

  });
}
/* invokeAll blocks until all service requests complete, 
 * or a max of 10 seconds. */
List<Future<User>> results = workers.invokeAll(tasks, 10, TimeUnit.SECONDS);
for (Future<User> f : results) {
  User user = f.get();
  /* Add user to batch update. */
  ...
}
/* Commit batch. */
...