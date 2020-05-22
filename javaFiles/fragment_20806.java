interface ReThrower {
  void reThrow() throws RuntimeException, ExecutionException, InterruptedException;
}
static class MyResult
{
  private final Set<SomeReturnType> valuesReturned;
  private final @Nullable ReThrower exception;

  public MyResult(Set<SomeReturnType> valuesReturned, ReThrower exception) {
    this.valuesReturned = valuesReturned;
    this.exception = exception;
  }

  public Set<SomeReturnType> getValuesReturned() {
    return valuesReturned;
  }

  public void reThrowException()
    throws RuntimeException, ExecutionException, InterruptedException
  {
    if(exception!=null) exception.reThrow();
  }
}