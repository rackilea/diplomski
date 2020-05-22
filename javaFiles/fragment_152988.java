public class NotRemovableArrayList<T> extends ArrayList<T> {
    @Override
    public boolean remove(Object o) {
        throw new UnsupportedOperationException();
    }

    ...
}