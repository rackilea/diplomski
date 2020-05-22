import java.util.ArrayList;
import java.util.Collection;

public final class Element<T> implements Comparable<Element<T>> {
    final long id;
    final Collection<T> value;

    public Element(int id, T value) {
        this.id = id;
        // Order preserving
        this.value = new ArrayList<T>();
        this.value.add(value);
    }

    Element(long id, Element<T> e1, Element<T> e2) {
        this.id = id;
        this.value = new ArrayList<T>();
        add(e1);
        add(e2);
    }

    private void add(Element<T> e1) {
        if(e1 == null) {
            this.value.add(null);           
        } else {
            this.value.addAll(e1.value);
        }
    }

    /**
     * Used as End-of-Stream marker 
     */
    Element() {
        id = -1;
        value = null;
    }

    @Override
    public int compareTo(Element<T> o) {
        return Long.compare(id, o.id);
    }
}