import java.util.ArrayList;
import java.util.List;

public class CompositeAutoclosable<T extends AutoCloseable> implements AutoCloseable {
    private final List<T> components= new ArrayList<>();

    public void addComponent(T component) { components.add(component); }

    public List<T> getComponents() { return components; }

    @Override
    public void close() throws Exception {
        Exception e = null;
        for (T component : components) {
            try { component.close(); }
            catch (Exception closeException) {
                if (e == null) { e = closeException; }
                else { e.addSuppressed(closeException); }
            }
        }
        if (e != null) { throw e; }
    }
}