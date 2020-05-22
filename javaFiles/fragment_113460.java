import java.beans.PropertyChangeListener;
import javax.swing.event.SwingPropertyChangeSupport;

public class Model2 {
    private SwingPropertyChangeSupport pcSupport = new SwingPropertyChangeSupport(this);
    public static final String TEXT = "text"; // name of our "bound" property
    private String text = "";

    public String getText() {
        return text;
    }

    public void setText(String text) {
        String oldValue = this.text;
        String newValue = text;
        this.text = text;
        pcSupport.firePropertyChange(TEXT, oldValue, newValue);
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        pcSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        pcSupport.removePropertyChangeListener(listener);
    }

    public void addPropertyChangeListener(String name, PropertyChangeListener listener) {
        pcSupport.addPropertyChangeListener(name, listener);
    }

    public void removePropertyChangeListener(String name, PropertyChangeListener listener) {
        pcSupport.removePropertyChangeListener(name, listener);
    }
}