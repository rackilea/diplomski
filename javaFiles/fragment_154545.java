public class MyCallable implements Callable<ResultType> {
  @Override
  public ResultType call() throws Exception {
    //do query, with 1s timeout - that way no thread will be busy for more than 1s
    return result;
  }
}