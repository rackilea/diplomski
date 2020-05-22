public class MySet<E> implements Iterable<E> {
    ...
    public Iterator<E> iterator() {
        return setList.iterator();
    }
}