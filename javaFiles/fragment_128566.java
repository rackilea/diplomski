void solve(Executor e, Collection<Callable<Result>> solvers)
     throws InterruptedException, ExecutionException {
       //This class will hold and execute your tasks
       CompletionService<Result> ecs
           = new ExecutorCompletionService<Result>(e);
       //Submit (start) all the tasks asynchronously
       for (Callable<Result> s : solvers)
           ecs.submit(s);
       //Retrieve completed task results and use them
       int n = solvers.size();
       for (int i = 0; i < n; ++i) {
           Result r = ecs.take().get();
           if (r != null)
               use(r);
       }
   }