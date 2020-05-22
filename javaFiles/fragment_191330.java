import java.util.*;

final class MultiSortedSetView<E> implements Iterable<E> {

    private final List<SortedSet<E>> sets = new ArrayList<>();
    private final Comparator<? super E> comparator;

    MultiSortedSetView() {
        comparator = null;
    }

    MultiSortedSetView(final Comparator<? super E> comp) {
        comparator = comp;
    }


    @Override
    public Iterator<E> iterator() {
        return new MultiSortedSetIterator<E>(sets, comparator);
    }


    MultiSortedSetView<E> add(final SortedSet<E> set) {
        // You may remove this `if` if you already know
        // every set uses the same comparator.
        if (comparator != set.comparator()) {
            throw new IllegalArgumentException("Different Comparator!");
        }
        sets.add(set);
        return this;
    }


    @Override
    public boolean equals(final Object o) {
        if (this == o) { return true; }
        if (!(o instanceof MultiSortedSetView)) { return false; }
        final MultiSortedSetView<?> n = (MultiSortedSetView<?>) o;
        return sets.equals(n.sets) &&
                (comparator == n.comparator ||
                (comparator != null ? comparator.equals(n.comparator) :
                    n.comparator.equals(comparator)));
    }

    @Override
    public int hashCode() {
        int hash = comparator == null ? 0 : comparator.hashCode();
        return 37 * hash + sets.hashCode();
    }

    @Override
    public String toString() {
        return sets.toString();
    }



    private final static class MultiSortedSetIterator<E>
            implements Iterator<E> {

        private final List<Iterator<E>> iterators;
        private final PriorityQueue<Element<E>> queue;

        private MultiSortedSetIterator(final List<SortedSet<E>> sets,
                final Comparator<? super E> comparator) {
            final int n = sets.size();
            queue = new PriorityQueue<Element<E>>(n,
                    new ElementComparator<E>(comparator));
            iterators = new ArrayList<Iterator<E>>(n);
            for (final SortedSet<E> s: sets) {
                iterators.add(s.iterator());
            }
            prepareQueue();
        }


        @Override
        public E next() {
            final Element<E> e = queue.poll();
            if (e == null) {
                throw new NoSuchElementException();
            }
            if (!insertFromIterator(e.iterator)) {
                iterators.remove(e.iterator);
            }
            return e.element;
        }

        @Override
        public boolean hasNext() {
            return !queue.isEmpty();
        }


        private void prepareQueue() {
            final Iterator<Iterator<E>> iterator = iterators.iterator();
            while (iterator.hasNext()) {
                if (!insertFromIterator(iterator.next())) {
                    iterator.remove();
                }
            }
        }

        private boolean insertFromIterator(final Iterator<E> i) {
            while (i.hasNext()) {
                final Element<E> e = new Element<>(i.next(), i);
                if (!queue.contains(e)) {
                    queue.add(e);
                    return true;
                }
            }
            return false;
        }



        private static final class Element<E> {
            final E element;
            final Iterator<E> iterator;

            Element(final E e, final Iterator<E> i) {
                element = e;
                iterator = i;
            }

            @Override
            public boolean equals(final Object o) {
                if (o == this) { return true; }
                if (!(o instanceof Element)) { return false; }
                final Element<?> e = (Element<?>) o;
                return element.equals(e.element);
            }
        }


        private static final class ElementComparator<E>
                implements Comparator<Element<E>> {
            final Comparator<? super E> comparator;

            ElementComparator(final Comparator<? super E> comp) {
                comparator = comp;
            }

            @Override
            @SuppressWarnings("unchecked")
            public int compare(final Element<E> e1, final Element<E> e2) {
                if (comparator != null) {
                    return comparator.compare(e1.element, e2.element);
                }
                return ((Comparable<? super E>) e1.element)
                        .compareTo(e2.element);
            }
        }
    }
}