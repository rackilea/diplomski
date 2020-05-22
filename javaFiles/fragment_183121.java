import java.util.ArrayList;

/**
 * The observer pattern.
 * @author jiman 
 */
public abstract class Observed {

    private ArrayList<Observer> observers;

    public Observed() { views = new ArrayList<Observer>(); }

    public void registerObserver(Observer o) { observers.add(o); }

    public void removeObserver(Observer o) { observers.remove(o); }

    // call this method upon a mutation of the state of this object
    public void notifyObservers() { for (Observer o : observers) o.update(); }

}