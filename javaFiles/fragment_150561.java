import java.util.Arrays;
import java.util.Iterator;

public class Container implements Iterator {

    private Iterator<?> iter;

    public Container(Object ...values) {
        this.iter = Arrays.asList(values).iterator();
    }

    @Override
    public boolean hasNext() {
        return iter.hasNext();
    }

    @Override
    public Object next() {
        return iter.next();
    }
}