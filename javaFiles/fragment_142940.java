public class Array2DSoftRefs<T> {

    private final Array2D<SoftReference<T>> inner = ...;

    public T get( int x , int y ) {
        return inner.get(x,y).get();
    }

    public void set( T o , int x , int y ) {
        inner.set(new SoftReference<T>(o), x, y);
    }
}