// we are synchronizing the list so no reason to use Collections.synchronizedList
private List<E> list = new ArrayList<E>();
...
public synchronized boolean add(E e) {
    return list.add(e);
}