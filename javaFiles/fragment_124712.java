import java.util.Observable;
import java.util.Observer;

class ObservedObject extends Observable {
    private String watchedValue;

    public ObservedObject(String value) {
        this.watchedValue = value;
    }

    public String getWatchedValue() {
        return watchedValue;
    }

    public void setWatchedValue(String value) {
        if (!watchedValue.equals(value)) {
            this.watchedValue = value;
            setChanged();
        }
    }
}

public class ObservableDemo implements Observer {
    public String name;

    public ObservableDemo(String name) {
        this.name = name;
    }

    public static void main(String[] args) {
        ObservedObject watched = new ObservedObject("Original Value");
        ObservableDemo watcher = new ObservableDemo("Watcher");
        watched.addObserver(watcher);
        System.out.println("setValue method called...");
        watched.setWatchedValue("New Value");
        if (watched.hasChanged()) {
            System.out.println("Value changed: " + watched.getWatchedValue());
        } else
            System.out.println("Value not changed");
    }

    public void update(Observable obj, Object arg) {
        System.out.println("Update called");
    }
}