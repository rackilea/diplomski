public class InstantIterator implements Iterator<Instant>,
                                        Iterable<Instant> {

    private Instant current;
    private final Instant original;
    private Duration skip;
    private List<Instant> skipThese;

    public InstantIterator(Instant startFrom, Duration skip) {
        this.current = original = startFrom;
        this.skip = skip;
        skipThese = new Vector<Instant>();
    }

    public boolean hasNext() {
        return true;
    }

    public Instant next() {
        Instant currentNext = current.toInstant();
        current = current.plus(skip);
        while (skipThese.contains(currentNext)) {
            currentNext = current.toInstant();
            current = current.plus(skip);
        }
        return currentNext;
    }

    public void remove() {
        skipThese.add(current.toInstant());
    }

    public Iterator<Instant> iterator() {
        return this;
    }

    public void rewind() {
        current = original.toInstant();
    }

    public void resetRemoved() {
        skipThese.clear();
    }

    public void resetIterator() {
        rewind();
        resetRemoved();
    }
}