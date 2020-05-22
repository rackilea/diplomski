class DelayedListener<ReqT> extends Listener<ReqT> {
  private Listener<ReqT> delegate;
  private List<Runnable> events = new ArrayList<Runnable>();

  @Override public synchronized void onMessage(ReqT message) {
    if (delegate == null) {
      events.add(() -> delegate.onMessage(message));
    } else {
      delegate.onMessage(message);
    }
  }
  ...
  public synchronized void setDelegate(Listener<ReqT> delegate) {
    this.delegate = delegate;
    for (Runnable runnable : events) {
      runnable.run();
    }
    events = null;
  }
}