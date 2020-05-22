public interface Tree<X, Y> extends Iterable<Tree<X, Y>> {
    X getKey();
    X getValue();
    Tree<X, Y> floor(X key);
    Tree<X, Y> ceiling(X key);
    Tree<X, Y> subTree(X lo, X hi);
    // ...
}

public class TreeImpl<X, Y> implements Tree<X, Y> {
    final X key;
    Y value;
    TreeImpl<X, Y> left, right;

    public TreeImpl(X key, Y value) {
        this.key = key;
        this.value = value;
    }

    @Override
    public Iterator<Tree<X, Y>> iterator() {
        return new TreeItr();
    }

    // Iterator starting at the most left to the most right;
    private class TreeItr implements Iterator<Tree<X, Y>> {
        // ...
    }

    @Override
    public Tree<X, Y> subTree(X lo, X hi) {
        return new SubTree<>(this, lo, hi);
    }

    private static class SubTree<X, Y> implements Tree<X, Y> {
        final Tree<X, Y> backing;
        final X lo, hi;

        public SubTree(Tree<X, Y> backing, X lo, X hi) {
            this.backing = backing;
            this.lo = lo;
            this.hi = hi;
        }

        @Override
        public Iterator<Tree<X, Y>> iterator() {
            return new SubTreeItr(backing.ceiling(lo), backing.floor(hi))
        }

        // Iterator starting at 'from' and returning 'hasNext() == false' after 'to'
        // has returned
        private class SubTreeItr implements Iterator<Tree<X, Y>> {
            final Tree<X, Y> from, to;

            public SubTreeItr(Tree<X, Y> from, Tree<X, Y> to) {
                this.from = from;
                this.to = to;
            }

            //...
        }

        @Override
        public Tree<X, Y> subTree(X lo, X hi) {
            // Check if lo > this.lo && hi < this.hi
            return new SubTree<>(backing, lo, hi);
        }
    }
}