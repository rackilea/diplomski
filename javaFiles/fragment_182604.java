class FacadeIterator implements Iterator<FacadeItem> {
    private final Iterator<Item> delegate; // set in ctor

    @Override
    public FacadeItem next() {
        return new FacadeItem(delegate.next());
    }

    // the other two methods just delegate straight
}