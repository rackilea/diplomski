public class TernaerTree<E> implements Iterable<E> {

    private TernaerTree left;
    private TernaerTree middle;
    private TernaerTree right;
    private E value;

    public E getValue() {
        return value;
    }

    public TernaerTree(TernaerTree left, TernaerTree middle, TernaerTree right, E value) {
        this.left = left;
        this.middle = middle;
        this.right = right;
        this.value = value;
    }

    @Override
    public Iterator<E> iterator() {
        return new WalkThroughIterator();
    }

    public class WalkThroughIterator implements Iterator<E> {

        // All the iterators of all of the sub-trees that weren't null.
        List<Iterator<E>> iterators = new LinkedList<>();
        // Have we delivered the element?
        private boolean deliveredElement = false;

        public WalkThroughIterator() {
            // Is there a 'left' tree?
            if (left != null) {
                iterators.add(left.iterator());
            }
            // a middle
            if (middle != null) {
                iterators.add(middle.iterator());
            }
            // a right
            if (right != null) {
                iterators.add(right.iterator());
            }
        }

        @Override
        public boolean hasNext() {
            // we've finished if we've delivered the element.
            return !deliveredElement;
        }

        @Override
        public E next() {
            // First consume the iterators.
            while (iterators.size() > 0) {
                // Grab the first one.
                Iterator<E> it = iterators.get(0);
                // Has it got an entry?
                if (it.hasNext()) {
                    // Return it's next.
                    return it.next();
                } else {
                    // It's exhaused - remove it.
                    iterators.remove(it);
                }
            }
            // We now deliver our element.
            deliveredElement = true;
            return value;
        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException("remove() is not supported.");
        }

    }

}

public void test() {
    TernaerTree<String> baum = new TernaerTree<String>(new TernaerTree<String>(null, null, null, "Hallo"), new TernaerTree<String>(null, null, null, "Welt"), new TernaerTree<String>(null, null, null, "?"), "!");
    for (String s : baum) {
        System.out.println(s);
    }
}