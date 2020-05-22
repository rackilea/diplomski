public class ArrayWrapper<E> {
  private E[] data;

  public ArrayWrapper(E[] data) {
    this.data = Arrays.copyOf(data, data.length);
  }

  @Override public boolean equals(Object other) {
    if (this == other) return true;
    if (!(other instanceof ArrayWrapper)) return false;
    ArrayWrapper o = (ArrayWrapper)other;
    if (this.data.size != o.data.size) return false;
    for (int i = 0; i < this.data.size; i++)
      if (!this.data[i].equals(o.data[i]) return false;
    return true;
  }
}