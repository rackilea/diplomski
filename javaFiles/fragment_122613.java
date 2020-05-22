public class LimitLinkedTransferQueue<E> {
    LinkedTransferQueue<E> queue = new LinkedTransferQueue<>();
    private final long maxSize;
    private long size = 0;

    public LimitLinkedTransferQueue(long maxSize) {
        super();
        this.maxSize = maxSize;
    }

    public boolean add(E e) {
        if (this.size == this.maxSize){
            return false;
        }
        boolean result = queue.add(e);
        if (result) {
            size++;
        }
        return result;
    }

    public E take() throws InterruptedException {
        E item = queue.take();
        size--;
        return item;
    }
    // other need methods
}