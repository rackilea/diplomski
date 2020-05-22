class Ref<T> {
  T obj;
  public Ref(T value) {
    this.obj = value;
  }
  public void set(T value) {
    obj = value;
  }
  public T get() {
    return obj;
  }
}