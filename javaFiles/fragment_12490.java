static class SynchronizedList<E>
    extends SynchronizedCollection<E>
    implements List<E> {

    final List<E> list;

    public boolean equals(Object o) {
        synchronized (mutex) {return list.equals(o);}
    }
    public int hashCode() {
        synchronized (mutex) {return list.hashCode();}
    }

    public ListIterator<E> listIterator() {
        return list.listIterator(); // Must be manually synched by user
    }