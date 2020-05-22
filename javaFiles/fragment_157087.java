public class ObservableImpl<T> implements Observable<T>{

    private final List<Observer<T>> observers = new ArrayList<Observer<T>>();

    @Override
    public void addObserver(Observer<T> o) {
        this.observers.add(o);
    }

    @Override
    public void removeObserver(Observer<T> o) {
        this.observers.remove(o);
    }

    @Override
    public void removeAllObservers() {
        this.observers.clear();     
    }

    @Override
    public void notifyObservers(T event) {      
        for(Observer<T> observer : observers) {
            observer.notify(event);
        }
    }

}