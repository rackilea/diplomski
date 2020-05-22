someQueue.post(new Callable<Void>() {
  @Override
  public Void call() {
    foo.MethodZ(someArgument);
    return null;
  }
});