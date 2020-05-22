class GeneralCallbackWrapper<T> implements AsyncCallback<T> {
  private final AsyncCallback<? super T> delegate;

  public GeneralCallbackWrapper(AsyncCallback<? super T> delegate) {
    this.delegate = delegate;
  }

  public void MethodFromAsyncCallback(T result) {
    // general stuff here
    delegate.MethodFromAsyncCallback(result);
  }
}