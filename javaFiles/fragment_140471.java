static class NamedKeeparator implements Iterator<DataPoint> {
    private final Iterator<DataPoint> delegate;
    private final String name;
    private DataPoint                 current;

    public NamedKeeparator(String name, Iterator<DataPoint> delegate) {
        this.delegate = delegate;
        this.name = name;
    }

    @Override
    public boolean hasNext() {
        return delegate.hasNext();
    }

    @Override
    public DataPoint next() {
        return current = delegate.next();
    }

    public DataPoint current() {
        return current;
    }

    public void consume() {
        current = null;
    }

    String getName() {
        return name;
    }
}