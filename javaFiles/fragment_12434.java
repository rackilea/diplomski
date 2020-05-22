public final class IListenerSet<T extends IListener> extends AbstractSet<T> {

    private final Map<IListener.Priority, Set<T>> map;

    public IListenerSet() {
        map = new EnumMap<>(IListener.Priority.class);
        for (IListener.Priority p : IListener.Priority.values())
            map.put(p, new LinkedHashSet<>());
    }

    public IListenerSet(Collection<? extends T> collection) {
        this();
        addAll(collection);
    }

    @Override
    public int size() {
        int size = 0;
        for (Set<T> set : map.values())
            size += set.size();
        return size;
    }

    @Override
    public boolean contains(Object o) {
        if (!(o instanceof IListener))
            return false;
        IListener listener = (IListener) o;
        IListener.Priority p = listener.getPriority();
        return p != null && map.get(p).contains(listener);
    }

    @Override
    public boolean add(T listener) {
        IListener.Priority p = listener.getPriority();
        if (p == null)
            throw new IllegalArgumentException();
        return map.get(p).add(listener);
    }

    @Override
    public boolean remove(Object o) {
        if (!(o instanceof IListener))
            return false;
        IListener listener = (IListener) o;
        IListener.Priority p = listener.getPriority();
        return p != null && map.get(p).remove(listener);
    }

    @Override
    public void clear() {
        for (Set<T> set : map.values())
            set.clear();
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {

            private Iterator<T> iterator = map.get(IListener.Priority.values()[0]).iterator();
            private int nextIndex = 1;
            private Iterator<T> nextIterator = null;

            @Override
            public boolean hasNext() {
                if (iterator.hasNext() || nextIterator != null)
                    return true;
                IListener.Priority[] priorities = IListener.Priority.values();
                while (nextIndex < priorities.length) {
                    Set<T> set = map.get(priorities[nextIndex++]);
                    if (!set.isEmpty()) {
                        nextIterator = set.iterator();
                        return true;
                    }
                }
                return false;
            }

            @Override
            public T next() {
                if (iterator.hasNext())
                    return iterator.next();
                if (!hasNext())
                    throw new NoSuchElementException();
                iterator = nextIterator;
                nextIterator = null;
                return iterator.next();
            }

            @Override
            public void remove() {
                iterator.remove();
            }
        };
    }
}