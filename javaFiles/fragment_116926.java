import java.util.ArrayList;

public class ActivityHolder implements Subject {
    private static ActivityHolder uniqueActivityHolder;
    private ArrayList observers;
    private String newValue; 

    private ActivityHolder() {
        observers = new ArrayList();
    }

    public static synchronized ActivityHolder getInstance() {
        if (uniqueActivityHolder == null) {
            uniqueActivityHolder = new ActivityHolder();
        }
        return uniqueActivityHolder;
    }

    public void registerObserver(Observer o) {
        observers.add(o);
    }

    public void removeObserver(Observer o) {
        int i = observers.indexOf(o);
        if (i >= 0) {
            observers.remove(i);
        }

    }

    public void notifyObserver() {
        for (int i = 0; i < observers.size(); i++) {
            Observer observer = (Observer) observers.get(i);
            observer.updateNewValue(newValue);
        }
    }

    public void valueChanged() {
        notifyObserver();
    }

    public void setNewValue(String _NewValue) {
        this.newValue = _NewValue;
        valueChanged();
    }
}