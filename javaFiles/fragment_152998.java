public class Container<T> implements Iterable<T> {

  // The capacity of the container.
  final int capacity;
  // The list.
  AtomicReference<Node<T>> head = new AtomicReference<Node<T>>();

  // Constructor
  public Container(int capacity) {
    this.capacity = capacity;
    // Construct the list.
    Node<T> h = new Node<T>();
    Node<T> it = h;
    // One created, now add (capacity - 1) more
    for (int i = 0; i < capacity - 1; i++) {
      // Add it.
      it.next = new Node<T>();
      // Step on to it.
      it = it.next;
    }
    // Make it a ring.
    it.next = h;
    // Install it.
    head.set(h);
  }

  // Empty ... NOT thread safe.
  public void clear() {
    Node<T> it = head.get();
    for (int i = 0; i < capacity; i++) {
      // Trash the element
      it.element = null;
      // Mark it free.
      it.free.set(true);
      it = it.next;
    }
    // Clear stats.
    resetStats();
  }

  // Add a new one.
  public Node<T> add(T element) {
    // Get a free node and attach the element.
    return getFree().attach(element);
  }

  // Find the next free element and mark it not free.
  private Node<T> getFree() {
    Node<T> freeNode = head.get();
    int skipped = 0;
    // Stop when we hit the end of the list 
    // ... or we successfully transit a node from free to not-free.
    while (skipped < capacity && !freeNode.free.compareAndSet(true, false)) {
      skipped += 1;
      freeNode = freeNode.next;
    }
    if (skipped < capacity) {
      // Put the head as next.
      // Doesn't matter if it fails. That would just mean someone else was doing the same.
      head.set(freeNode.next);
    } else {
      // We hit the end! No more free nodes.
      throw new IllegalStateException("Capacity exhausted.");
    }
    return freeNode;
  }

  // Mark it free.
  public void remove(Node<T> it, T element) {
    // Remove the element first.
    it.detach(element);
    // Mark it as free.
    if (!it.free.compareAndSet(false, true)) {
      throw new IllegalStateException("Freeing a freed node.");
    }
  }

  // The Node class. It is static so needs the <T> repeated.
  public static class Node<T> {

    // The element in the node.
    private T element;
    // Are we free?
    private AtomicBoolean free = new AtomicBoolean(true);
    // The next reference in whatever list I am in.
    private Node<T> next;

    // Construct a node of the list
    private Node() {
      // Start empty.
      element = null;
    }

    // Attach the element.
    public Node<T> attach(T element) {
      // Sanity check.
      if (this.element == null) {
        this.element = element;
      } else {
        throw new IllegalArgumentException("There is already an element attached.");
      }
      // Useful for chaining.
      return this;
    }

    // Detach the element.
    public Node<T> detach(T element) {
      // Sanity check.
      if (this.element == element) {
        this.element = null;
      } else {
        throw new IllegalArgumentException("Removal of wrong element.");
      }
      // Useful for chaining.
      return this;
    }

    @Override
    public String toString() {
      return element != null ? element.toString() : "null";
    }
  }

  // Provides an iterator across all items in the container.
  public Iterator<T> iterator() {
    return new UsedNodesIterator<T>(this);
  }

  // Iterates across used nodes.
  private static class UsedNodesIterator<T> implements Iterator<T> {
    // Where next to look for the next used node.

    Node<T> it;
    int limit = 0;
    T next = null;

    public UsedNodesIterator(Container<T> c) {
      // Snapshot the head node at this time.
      it = c.head.get();
      limit = c.capacity;
    }

    public boolean hasNext() {
      if (next == null) {
        // Scan to the next non-free node.
        while (limit > 0 && it.free.get() == true) {
          it = it.next;
          // Step down 1.
          limit -= 1;
        }
        if (limit != 0) {
          next = it.element;
        }
      }
      return next != null;
    }

    public T next() {
      T n = null;
      if ( hasNext () ) {
        // Give it to them.
        n = next;
        next = null;
        // Step forward.
        it = it.next;
        limit -= 1;
      } else {
        // Not there!!
        throw new NoSuchElementException ();
      }
      return n;
    }

    public void remove() {
      throw new UnsupportedOperationException("Not supported.");
    }
  }

  @Override
  public String toString() {
    StringBuilder s = new StringBuilder();
    Separator comma = new Separator(",");
    // Keep counts too.
    int usedCount = 0;
    int freeCount = 0;
    // I will iterate the list myself as I want to count free nodes too.
    Node<T> it = head.get();
    int count = 0;
    s.append("[");
    // Scan to the end.
    while (count < capacity) {
      // Is it in-use?
      if (it.free.get() == false) {
        // Grab its element.
        T e = it.element;
        // Is it null?
        if (e != null) {
          // Good element.
          s.append(comma.sep()).append(e.toString());
          // Count them.
          usedCount += 1;
        } else {
          // Probably became free while I was traversing.
          // Because the element is detached before the entry is marked free.
          freeCount += 1;
        }
      } else {
        // Free one.
        freeCount += 1;
      }
      // Next
      it = it.next;
      count += 1;
    }
    // Decorate with counts "]used+free".
    s.append("]").append(usedCount).append("+").append(freeCount);
    if (usedCount + freeCount != capacity) {
      // Perhaps something was added/freed while we were iterating.
      s.append("?");
    }
    return s.toString();
  }
}