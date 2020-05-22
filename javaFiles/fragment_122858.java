/**
 * Prevents internal interceptor calls from within intercepted methods.
 * Not thread safe.
 */
public abstract class GuardedInteceptor implements MethodInterceptor {
  private boolean executionInProgress = false;

  /** No-op if in the middle of an intercepted method. */
  public Object invoke(MethodInvocation invocation) throws Throwable {
    if (executionInProgress) {
      return invocation.proceed();
    }
    executionInProgress = true;
    Object returnValue = null;
    try {
      runBefore();
      returnValue = invocation.proceed();
      runAfter();
    } finally {
      executionInProgress = false;
    }
    return returnValue;
  }

  protected abstract void runBefore();
  protected abstract void runAfter();
}