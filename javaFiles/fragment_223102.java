public final class Singleton<T> {
  private final T value;
  public Singleton(T value) {
    this.value = value;
  }
  private final T get() {
    return value;
  }
}