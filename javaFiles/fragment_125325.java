public class MyCallable implements Callable<Integer> { //Callable is like Runnable but can return value
  private Integer value;

  public MyCallable(Integer v) {
    value = v;
  }

  public Integer call() {
    return value;
  }

  public static void main(String[] args) {
    ExecutorService exec = Executors.newFixedThreadPool(3); //Creating thread pool with 3 worker threads
    List<Integer> values = Arrays.asList(1, 2, 3);
    List<Future<Integer>> futures = new ArrayList<>(values.size());
    List<Integer> newValues = new ArrayList<>(values.size());

    for (Integer v : values) {
        futures.add(exec.submit(new MyCallable(v))); //Submit tasks to worker threads to do stuff in background
    }

    for (Future<Integer> f : futures) {
        try {
            newValues.add(f.get()); // get calculated result from worker thread or block waiting for result to become available
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
    }

    System.out.println(newValues);
    exec.shutdownNow();
  }
}