public class DequeIterator<E> implements Iterator<E> {

    ...
    private boolean isDesc;

    public DequeIterator( boolean isdesc ) {
        ...
        this.isDesc = isdesc;
    }

   ...

    @Override
    public E next() {
        return (E) deque.get(isDesc ? index-- : index++);
    }

    ...
}