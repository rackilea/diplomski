@Component
class AsyncTask {
  @Async
  public Future<String> call() throws InterruptedException {
    return new AsyncResult<String>("return value");
  }
}