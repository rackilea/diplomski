public class Observer implements IObserver {

    Map<AbstractObservable, IObserverVisitor> observableMap =
            new HashMap<AbstractObservable, IObserverVisitor>();

    public void add(AbstractObservable observable, IObserverVisitor visitor) {
        observableMap.put(observable, visitor);
    }

    public void remove(AbstractObservable observable) {
        observableMap.remove(observable);
    }

    public void removeAll() {
        observableMap.clear();
    }

    public void update(Observable o, Object arg) {
        observableMap.get(o).visit(this, o, arg);
    }

}