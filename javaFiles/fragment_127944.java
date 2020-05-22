import java.util.Iterator;

public class StateSpace<T extends AbstractState> implements Iterable<T> {
    List<T> types;
    int pos;

    public StateSpace() {
        types = new ArrayList<>();
    }
    public void add(T type) {
        types.add(type);
    }
    T getNext() {
        return types.get(pos++);
    }
    boolean hasNext() {
         return pos < types.size()-1;
    }
    @Override
    public Iterator<T> iterator() {
        return new StateIterator(this);
    }
}