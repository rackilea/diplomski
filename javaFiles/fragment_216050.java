/**
 * Implementation of {@link java.util.Queue} that represents a continuous queue of ordered data.
 * Elements are automatically sorted when added, by a given {@link Comparator}
 * This class is useful for something like a turn based game, in which a group of users take turns to perform
 * an action, and then repeat back to the first user.
 * Because of this, direct iteration or looping over <strong>WILL REPEAT INDEFINITELY</strong>, causing an
 * infinite loop.
 * A more suited example would be something like:
 * <p>
 * var currentPlayingUser;
 * while(game in progress){
 * //wait for the user to take their turn
 * currentPlayingUser = queue.poll();
 * }
 *
 * @param <T> The type of element in the queue
 * @author Alexander Wood http://bristermitten.me
 */
public class SortedRepeatingQueue<T> extends AbstractQueue<T> {

    /**
     * Internal list for this implementation.
     * This list is guaranteed to be sorted at all times
     */
    private final List<T> backingList = new ArrayList<>();
    private Comparator<T> comparator;
    private Itr iterator = iterator();

    public SortedRepeatingQueue(Comparator<T> comparator) {
        this.comparator = comparator;
    }

    /**
     * Return, but do not remove the head element.
     * Due to the cyclic nature, removing the head element would not match the intended functionality.
     * However, this will cycle through the elements. That is, given a SortedRepeatingQueue [1,2,3]
     * poll will return 1, then 2, then 3, then 1, etc
     * <p>
     * This is functionally equivalent to the head element being moved to the tail rather than removed, although
     * is not what happens.
     *
     * @return The "head" element of this SortedRepeatingQueue
     */
    @Override
    public T poll() {
        return iterator.next();
    }

    @Override
    public T peek() {
        return iterator.nextWithoutCycle();
    }

    @Override
    public boolean offer(T t) {
        return add(t);
    }

    public boolean add(T e) {
        backingList.add(e);
        backingList.sort(comparator);
        return true;
    }

    public boolean addAll(Collection<? extends T> c) {
        boolean b = backingList.addAll(c);
        backingList.sort(comparator);
        return b;
    }

    public boolean remove(Object o) {
        return backingList.remove(o);
    }

    public Itr iterator() {
        return new Itr();
    }

    public int size() {
        return backingList.size();
    }

    @Override
    public String toString() {
        return "SortedRepeatingQueue{" +
                "backingList=" + backingList +
                '}';
    }

    private class Itr implements Iterator<T> {
        private int cursor = 0;

        public boolean hasNext() {
            return true;
        }

        public T next() {
            if (cursor == backingList.size()) {
                cursor = 0;
            }
            return backingList.get(cursor++);
        }

        public T nextWithoutCycle() {
            if (cursor == backingList.size()) {
                cursor = 0;
            }
            return backingList.get(cursor);
        }

        public void remove() {
            if (cursor == backingList.size()) {
                cursor = 0;
            }
            backingList.remove(cursor);
        }
    }
}