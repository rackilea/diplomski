import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import javax.swing.SwingWorker;

public class SwingWorkerListener<W extends SwingWorker> implements PropertyChangeListener {

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        W worker = (W) evt.getSource();
        switch (evt.getPropertyName()) {
            case "state":
                workerStateChanged(worker);
                switch (worker.getState()) {
                    case STARTED:
                        workerStarted(worker);
                        break;
                    case DONE:
                        workerDone(worker);
                        break;
                }
                break;
            case "progress":
                workerProgressUpdated(worker);
                break;
        }
    }

    protected void workerProgressUpdated(W worker) {
    }

    protected void workerStateChanged(W worker) {
    }

    protected void workerStarted(W worker) {
    }

    protected void workerDone(W worker) {
    }

}