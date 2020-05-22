class MethodZExecutor implements Callable<Void> {

  private final Methods method;
  private int argument;

  public MethodZExecutor(Methods method, int argument) {
    this.method = method;
    this.argument = argument;
  }

  @Override
  public Void call() {
    method.MethodZ(argument);
    return null;
  }
}