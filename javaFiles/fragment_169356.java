// addObserver() adds last-most at end of the list
public synchronized void addObserver(Observer o) {
    ..
    obs.addElement(o);
}

public void notifyObservers(Object arg) {
    ..
    // notifyObservers iterates backwards; last-most first.
    for (int i = arrLocal.length-1; i>=0; i--)
        ((Observer)arrLocal[i]).update(this, arg);
}