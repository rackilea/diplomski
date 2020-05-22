public class Repository<E> {

  private final ConcurrentMap<String,E> elements = new ConcurrentHashMap<>();

  public void add(String name, E element) {
    elements.put(name, element);
  }

  public E get(String name) {
    return elements.get(name);
  }

  public void remove(String name) {
    elements.remove(name);
  }
}