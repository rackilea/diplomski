public class AutoDiscardingDeque<E> extends LinkedBlockingDeque<E> {

    public AutoDiscardingDeque() {
        super();
    }

    public AutoDiscardingDeque(int capacity) {
        super(capacity);
    }

    @Override
    public synchronized boolean offerFirst(E e) {
        if (remainingCapacity() == 0) {
            removeLast();
        }
        super.offerFirst(e);
        return true;
    }
}