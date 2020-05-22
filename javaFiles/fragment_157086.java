public interface Observable<T> extends ObservableRegistration<T> {  
    void notifyObservers(T event);
}

public interface ObservableRegistration<T> {

    void addObserver(Observer<T> o);
    void removeObserver(Observer<T> o);
    void removeAllObservers();
}