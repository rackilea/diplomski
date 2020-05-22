public class ST2<K extends Comparable<K>, V> {

  Item[] items;
  int N;


  public class Item {

    public K key;
    public V value;

    public Item(K key, V value) {
      this.key = key;
      this.value = value;
    }
  }

  public ST2(int capacity) {
    items = (Item[]) new Object[capacity];
  }

  public K get(int index) {
    return items[index].key;
  }
}