public class MyHashMap<K, V> extends HashMap<K, V> {
  TheadLocal special = new TheadLocal ();

  public MyHashMap<K, V>() {
    super();
  }

  public V get(K key) {
    if ("special".equals (key))
       return special.get ();

    return super.get(key);
  }
}