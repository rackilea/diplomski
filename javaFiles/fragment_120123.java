import java.util.LinkedList;
import java.util.List;

public class EventBean {

    private final List<Listener> listeners = new LinkedList<Listener>();

    protected final <T> void firePropertyChanged(final String property,
            final T oldValue, final T newValue) {
        assert(property != null);
        if((oldValue != null && oldValue.equals(newValue))
                || (oldValue == null && newValue == null))
            return;
        for(final Listener listener : this.listeners) {
            try {
                if(listener.getProperties().contains(property))
                    listener.propertyChanged(property, oldValue, newValue);
            } catch(Exception ex) {
                // log these, to help debugging
                ex.printStackTrace();
            }
        }
    }

    public final boolean addListener(final Listener x) {
        if(x == null) return false;
        return this.listeners.add(x);
    }
    public final boolean removeListener(final Listener x) {
        return this.listeners.remove(x);
    }

}