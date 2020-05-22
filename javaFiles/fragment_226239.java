final class MyTask implements Callable<Void> {

  private final String value;

  MyTask(String value) { this.value = value; }

  @Override
  public Void call() throws InterruptedException {
    String result = doWork();
    handleResult(result);
    return null;
  }

  private String doWork() throws InterruptedException {
    int sleep = ThreadLocalRandom.current().nextInt(10) * 100;
    System.out.println("sleep in " + sleep);
    Thread.sleep(sleep);
    return value;
  }

  private void handleResult(String result) {
    System.out.println("result is " + result);
  }

}