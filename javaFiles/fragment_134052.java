static class Collector<T,U> implements Iterator<U> {
    Iterator<T> delegate ;
    Mapper<T,U> mapper ;

    public Collector( Iterable<T> elements, Mapper<T,U> c ) {
        delegate = elements.iterator() ;
        this.mapper = c ;
    }

    @Override
    public void remove() { delegate.remove() ; }
    @Override
    public boolean hasNext() { return delegate.hasNext() ; }
    @Override
    public U next() { return mapper.apply( delegate.next() ) ; }
}