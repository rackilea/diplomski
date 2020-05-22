public class DummyIterator<O> implements Iterator<O>{
    public boolean hasNext() {
        return false;
    }

    public O next() {
        return null;
    }
}