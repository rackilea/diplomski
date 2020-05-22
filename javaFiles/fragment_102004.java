abstract class CallbackBase<T> implements AsyncCallback<T> {
  public abstract void doStuff(T result);

  public void MethodFromAsyncCallback(T result) {
    // general stuff (T is a subclass of Object)
    doStuff(result);
  }
}