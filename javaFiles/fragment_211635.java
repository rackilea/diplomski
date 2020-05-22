public class FooIterator<E> implements Iterator<E> {

    public FooIterator(Collection<Bar> bars, BarConverter<E> converter) {
        innerIterator = bars.iterator();
        this.converter = converter;
    }

    @Override
    public E next() {
        Bar bar = innerIterator.next();
        return converter(bar);
    }
}