public class FutureProxy implements Future<Integer> {
    private Calculator calculator;
    private Future<Integer> delegate;
    public FutureProxy(Calculator calculator, Future<Integer> delegate) {
        this.calculator = calculator;
        this.delegate = delegate;
    }
    // proxy all of the methods
    public boolean isDone() {
        return delegate.isDone();
    }
    ...
    // for get, you can then call back to `calculator`
    public Integer get() throws InterruptedException, ExecutionException {
        Integer result = delegate.get();
        calculator.setCachedCalculation(result);
        return result;
    }
    // need to handle get(long, TimeUnit) as well
    public Integer get(long timeout, TimeUnit unit)
          throws InterruptedException, ExecutionException, TimeoutException;
        Integer result = delegate.get(timeout, unit);
        calculator.setCachedCalculation(result);
        return result;
    }
}