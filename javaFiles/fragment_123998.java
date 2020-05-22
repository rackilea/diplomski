public class Value { 
  final public WeakReference<Key> key;
  public Value(Key k) {
    this.key = new WeakReference<Key>(k);
  }
}