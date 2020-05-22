public enum IterationResult {
    NEXT, REMOVE, BREAK;
}

public interface CollectionIterator<T> {
    IterationResult onObject(T object);
}

public interface CollectionModification<T> {
    CollectionModification<T> add(T item);
    CollectionModification<T> remove(T item);
}

public class MyCollection<T> {            
    private volatile State          state;
    private final ReentrantLock     modificationLock = new ReentrantLock();
    private State                   currentModification;

    public MyCollection() {
        this(10);
    }

    public MyCollection(int initialSize) {
        state = new State(initialSize);
    }

    public CollectionModification<T> startModification() {
        modificationLock.lock();                
        currentModification = new State(state);
        return currentModification;
    }

    public void finishModification() {
        state = currentModification;
        modificationLock.unlock();
    }

    @SuppressWarnings("unchecked")
    public void iterate(CollectionIterator<T> it) {
        final State currentState = state;

        State modifiedState = null;
        try {
            out_:
            for (int i = 0; i < currentState.size; i++) {
                final T item = (T) currentState.items[i]; // unchecked
                final IterationResult result = it.onObject(item);
                switch (result) {
                    case BREAK:
                        break out_;
                    case REMOVE:
                        if (modifiedState == null) {                                    
                            modifiedState = (State) startModification();                                                                        
                        }
                        modifiedState.removeExactly(item);                                
                        break;
                    default:
                        break;
                }
            }
        } finally {
            if (modifiedState != null) {
                finishModification();
            }
        }
    }

    private class State implements CollectionModification<T> {
        private Object[]            items;
        private int                 size;

        private State(int initialSize) {
            items = new Object[initialSize];
        }

        private State(State from) {
            items = new Object[from.items.length];
            size = from.size;
            System.arraycopy(from.items, 0, items, 0, size);
        }

        @Override
        public CollectionModification<T> add(T item) {
            if (size == items.length) {
                final Object[] newItems = new Object[size + size >>> 1];
                System.arraycopy(items, 0, newItems, 0, size);
                items = newItems;
            }

            items[size] = item;

            size++;

            return this;
        }

        @Override
        public CollectionModification<T> remove(T item) {
            for (int i = 0; i < size; i++) {
                if (Objects.equals(item, items[i])) {
                    removeItem(i);
                    break;
                }
            }                    
            return this;
        }                

        private void removeExactly(T item) {
            for (int i = 0; i < size; i++) {
                if (item == items[i]) {
                    removeItem(i);
                    break;
                }
            }                    
        }                

        private void removeItem(int index) {
            if (index < items.length - 1) {
                System.arraycopy(items, index + 1, items, index, size - 1);
            }
            size--;
        }
    }            
}