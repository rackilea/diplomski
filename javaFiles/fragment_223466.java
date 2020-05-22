class YourFutureTask extends FutureTask<String> {

  private Callable<String> callable;

  public YourFutureTask(Callable<String> callable){
     super(callable);
     this.callable = callable;
  }

  public Callable<String> getCallable(){
     return callable;
  }
}