public interface Factory<T> {
    public T create();
}

private static <T> void addToSize( ArrayList<T> list, Factory<T> factory, int size ) {
    int currentSize = list.size();

    for ( int i = currentSize; i < size; i++ ) {
        list.add( factory.create() );
    }
}