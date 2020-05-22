public final class ConcurrentHashSet<E> extends ForwardingSet<E>
    implements Set<E>, Queue<E> {
  private enum Dummy { VALUE }

  private final ConcurrentMap<E, Dummy> map;

  ConcurrentHashSet(ConcurrentMap<E, Dummy> map) {
    super(map.keySet());
    this.map = Preconditions.checkNotNull(map);
  }

  @Override public boolean add(E element) {
    return map.put(element, Dummy.VALUE) == null;
  }

  @Override public boolean addAll(Collection<? extends E> newElements) {
    // just the standard implementation
    boolean modified = false;
    for (E element : newElements) {
      modified |= add(element);
    }
    return modified;
  }

  @Override public boolean offer(E element) {
    return add(element);
  }

  @Override public E remove() {
    E polled = poll();
    if (polled == null) {
      throw new NoSuchElementException();
    }
    return polled;
  }

  @Override public E poll() {
    for (E element : this) {
      // Not convinced that removing via iterator is viable (check this?)
      if (map.remove(element) != null) {
        return element;
      }
    }
    return null;
  }

  @Override public E element() {
    return iterator().next();
  }

  @Override public E peek() {
    Iterator<E> iterator = iterator();
    return iterator.hasNext() ? iterator.next() : null;
  }
}