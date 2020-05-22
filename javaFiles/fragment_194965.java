public abstract class OneArgStuffDoer<T1> implements StuffDoer {
  private final T1 arg;
  public OneArgStuffDoer(T1 arg) {
    this.arg = Objects.requireNonNull(arg);
  }
  public final void run() {
    run(arg);
  }
  abstract void run(T1 arg);
}