import java.util.Collections;
import java.util.Set;
import java.util.TreeSet;

// Must be in same package as EventBean!
public abstract class Listener {

    private final Set<String> properties;

    public Listener(String... properties) {
        Collections.addAll(this.properties = new TreeSet<String>(), properties);
    }

    protected final Set<String> getProperties() {
        return this.properties;
    }

    public abstract <T> void propertyChanged(final String property,
            final T oldValue, final T newValue);
}