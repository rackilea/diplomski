class UIThreadAwareResult<T> implements IResult<T> {

  private IResult<T> delegate;

  public UIThreadAwareResult(IResult<T> delegate) {
    this.delegate = delegate;
  }

  @Override
  public void onResult(T result) {
    invokeOnUIThread(result);
  }

  private void invokeOnUIThread(final T result) {
    try {
      EventQueue.invokeAndWait(new Runnable() {
        @Override
        public void run() {
          delegate.onResult(result);
        }
      });
    } catch (Exception e) {
      throw new RuntimeException(e);
    }
  }
}