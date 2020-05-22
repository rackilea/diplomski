public class WeakObserver implements Observer {
    private final WeakReference<Observer> observer;
    private final Observable observed;

    public WeakObserver(Observer observer, Observable observed){
        this.observer = new WeakReference<Observer>(observer);
        this.observed = observed;
    }

    @Override
    public void update(Observable o, Object arg) {
        Observer realObserver = observer.get();

        if (realObserver != null) {
            realObserver.update(o, arg);
        } else {
            observed.deleteObserver(this);
        }
    }
}