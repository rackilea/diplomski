class ObjectHolder<T> {
  public T data;
  public final int x, y;

  ObjectHolder(int x, int y, T data) {
    this.data = data;
    this.x = x;
    this.y = y;
  }
}