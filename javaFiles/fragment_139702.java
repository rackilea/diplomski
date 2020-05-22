public abstract class List<A> implements Iterable<A> {
    ...
    public abstract long size();

    @Override
    public Spliterator<A> spliterator() {
        return Spliterators.spliterator(iterator(), size(), Spliterator.ORDERED);
    }
}

class Nil extends List {
    ...
    public long size() {
        return 0;
    }
}

class Cons<A> extends List<A> {
    ...
    private final long size;

    Cons(A head, List<A> tail) {
        this.head = head;
        this.tail = tail;
        this.size = tail.size()+1;
    }

    ...

    @Override
    public long size() {
        return size;
    }
}