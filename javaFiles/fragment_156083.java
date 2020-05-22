public class CollectingIterator implements Iterator<Collection<MyClass>> {


    private boolean hasNext;
    private LinkedList<MyClass> next = new LinkedList<MyClass>();

    private final Iterator<MyClass> baseIterator;

    public CollectingIterator(Iterator<MyClass> baseIterator) {
        this.baseIterator = baseIterator;
        toNext();
    }

    @Override
    public boolean hasNext() {
        return hasNext;
    }

    @Override
    public Collection<MyClass> next() {
        Collection<MyClass> next = new LinkedList<MyClass>(this.next);
        toNext();
        return next;
    }

    private void toNext() {
        next.clear();
        boolean isSame = true;
        while (baseIterator.hasNext() && isSame) {
            if (next.isEmpty()) {
                next.add(baseIterator.next());
            } else {
                final MyClass nextElement = baseIterator.next();
                final MyClass last = next.getLast();
                next.add(nextElement);
                if (!last.getSomeField().equals(nextElement.getSomeField())) {
                    isSame = false;
                }
            }
        }

        this.hasNext = baseIterator.hasNext() || !next.isEmpty();
    }
}