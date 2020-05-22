public class ObservableBlockingQueue<E> extends LinkedBlockingQueue<E> {
     private ISaturatedPoolObserver observer;
     private int capacity;
     public ObservableBlockingQueue(ISaturatedPoolObserver observer,
         int capacity) {
         super(capacity);
         this.observer = observer;
         this.capacity = capacity;
    }
    @Override
    public boolean offer(E o) {
        boolean offered = super.offer(o);
        if (!offered) {
            observer.onSaturated();
        }
        return offered;
    }
    @Override
    public boolean offer(E o, long timeout, TimeUnit unit) throws InterruptedException {
        boolean offered = super.offer(o, timeout, unit);
        if (!offered) {
            observer.onSaturated();
        }
        return offered;
    }
    @Override
    public E poll() {
        E e = super.poll();
        if (e != null) {
             checkUnsaturated();
        }
        return e;
    }
    @Override
    public E poll(long timeout, TimeUnit unit) throws InterruptedException {
        E e = super.poll(timeout, unit);
        if (e != null) {
             checkUnsaturated();
        }
        return e;
    }
    @Override
    public E take() throws InterruptedException {
        E e = super.take();
        checkUnsaturated();
        return e;
    }
    @Override
    public boolean remove(E e) throws InterruptedException {
        boolean removed = super.remove(e);
        if (removed) {
            checkUnsaturated();
        }
        return removed;
    }
    private void checkUnsaturated() {
        if (super.size() * 100 / capacity < UNSATURATED_PERCENTAGE) {
            observer.onUnsaturated();
        }
    }
}