// wrap tasks A, B and C into runnables (or callables if you need some result):
Callable<Result> taskA = ...;
Callable<Result> taskB = ...;
Callable<Result> taskC = ...;

// create an ExecutorCompletionService
// to which you must pass an ExecutorService
// (choose one according to your precise use case)
// (the newCachedThreadPoolExecutor might not be a sensible choice)
ExecutorCompletionService e = new ExecutorCompletionService(Executors.newCachedThreadPoolExecutor());

Set<Future<Result>> futures = new HashSet<>();

// submit your tasks:
futures.add(e.submit(taskA));
futures.add(e.submit(taskB));
futures.add(e.submit(taskC));

// now call take() on the executor completion service,
// which will block the calling thread until the first task has completed
// either succesfully or abruptly (with an exception)
Future<Result> f = e.take();