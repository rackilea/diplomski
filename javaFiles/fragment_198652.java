public class LimitingList<E> extends ForwardingList<E> {

    private final class LimitingListIterator extends ForwardingListIterator<E> {

        private final ListIterator<E> innerListIterator;

        private LimitingListIterator(final ListIterator<E> innerListIterator) {
            this.innerListIterator = innerListIterator;
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public void add(final E element) {
            if (inner.size() < maxSize)
                innerListIterator.add(element);
            else
                throw new IndexOutOfBoundsException();
        }

        @Override
        protected ListIterator<E> delegate() {
            return innerListIterator;
        }
    }

    public LimitingList(final int maxSize) {
        this(new ArrayList<E>(), maxSize);
    }

    public LimitingList(final List<E> inner, final int maxSize) {
        super();
        this.inner = inner;
        this.maxSize = maxSize;
    }

    @Override
    public boolean addAll(final Collection<? extends E> collection) {
        boolean changed = false;
        for (final E item : collection) {
            final boolean tmpChanged = add(item);
            changed = changed || tmpChanged;
            if (!tmpChanged)
                break;
        }
        return changed;
    }

    @Override
    public boolean add(final E e) {
        if (inner.size() < maxSize)
            return super.add(e);
        else
            return false;
    }

    @Override
    public ListIterator<E> listIterator() {
        return new LimitingListIterator(inner.listIterator());
    }

    @Override
    public void add(final int index, final E element) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean addAll(final int index, final Collection<? extends E> elements) {
        throw new UnsupportedOperationException();
    }

    @Override
    public ListIterator<E> listIterator(final int index) {
        return new LimitingListIterator(inner.listIterator(index));
    }

    private final int maxSize;
    private final List<E> inner;

    @Override
    protected List<E> delegate() {
        return inner;
    }

}