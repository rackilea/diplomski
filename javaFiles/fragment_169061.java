import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class ProcessStatus {
    public static final String PROGRESS = "Progress";

    private PropertyChangeSupport propertyChangeSupport;

    private int progress = 0;

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        propertyChangeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        propertyChangeSupport.removePropertyChangeListener(listener);
    }

    protected void firePropertyChange(String propertyName, Object oldValue, Object newValue) {
        propertyChangeSupport.firePropertyChange(propertyName, oldValue, newValue);
    }

    public void setProgress(int progress) {
        int oldProgress = progress;
        this.progress = progress;
        firePropertyChange(PROGRESS, oldProgress, progress);
    }

    public int getProgress() {
        return progress;
    }
}

public class SomeWorker extends SwingWorker implements PropertyChangeListener {
    public void doInBackground() {
        ProcessStatus status = new ProcessStatus();
        status.addPropertyChangeListener(this);
        ProcessorThingy processor = new ProcessorThingy(status);
        processor.doStuff();
    }

    public void propertyChange(PropertyChangeEvent evt) {
        if (evt.getPropertyName().equals(ProcessStatus.PROGRESS)) {
            publish((Integer) evt.getNewValue());
        }
    }
}

public class ProcessorThingy {
    private ProcessStatus status;

    public ProcessorThingy(ProcessStatus status) {
        this.status = status;
    }

    public void doStuff() {
        //stuff part 1
        status.setProgress(10);
        //stuff part 2
        status.setProgress(50);
        //stuff part 3
        status.setProgress(100);
    }
}