import java.util.Arrays;
import java.util.Iterator;

public class Container implements Iterator {

    private Iterator<Runnable> iter;

    public Container(Runnable ...values) {
        this.iter = Arrays.asList(values).iterator();
    }

    @Override
    public boolean hasNext() {
        return iter.hasNext();
    }

    @Override
    public Object next() {
        Runnable next = iter.next();
        next.run();
        return next;
    }
}