import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public abstract class Test<T> {

    private List<T> devices = new ArrayList<T>();
    private Class<T> deviceClass;

    public Test(Class<T> deviceClass) {
        this.deviceClass = deviceClass;
    }

    public T find(T device) {
        Iterator<T> iterator = devices.iterator();
        while (iterator.hasNext()) {
            T current = iterator.next();
            if (current.equals(device)) {
                return current;
            }

        }
        return null;
    }
}