class LazyIterator implements Iterator<Foo> {
    private Iterator<Foo> backingIterator = null; //set this later

    private void lazyLoad() {
        if (backingIterator != null) {
            return;
        }
        //load the backing collection and assign to backingIterator here
    }

    @Override
    public boolean hasNext() {
        lazyLoad();
        return backingIterator.hasNext();
    }

    @Override
    public Foo next() {
        lazyLoad();
        return backingIterator.next();
    }

    @Override
    public void remove() {
        lazyLoad();
        backingIterator.remove();
    }
}