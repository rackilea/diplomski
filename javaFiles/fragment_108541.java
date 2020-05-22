public class AbstractObservable extends Observable{

    public synchronized void addObserver(IObserver o, IObserverVisitor visitor) {
        o.add(this, visitor);
        super.addObserver(o);
    }

    public synchronized void deleteObservers(IObserver o) {
        o.removeAll();
        super.deleteObservers();
    }

    public synchronized void deleteObserver(IObserver o) {
        o.remove(this);
        super.deleteObserver(o);
    }

    @Override
    public synchronized void deleteObserver(Observer o) {
        throw new UnsupportedOperationException();
    }

    @Override
    public synchronized void addObserver(Observer o) {
        throw new UnsupportedOperationException();
    }

    @Override
    public synchronized void deleteObservers() {
        throw new UnsupportedOperationException();
    }

    @Override
    public synchronized int countObservers() {
        return super.countObservers();
    }

    @Override
    public synchronized boolean hasChanged() {
        return super.hasChanged();
    }

    @Override
    public void notifyObservers() {
        super.notifyObservers();
    }

    @Override
    public void notifyObservers(Object arg) {
        super.notifyObservers(arg);
    }

    @Override
    protected synchronized void clearChanged() {
        super.clearChanged();
    }

    @Override
    protected synchronized void setChanged() {
        super.setChanged();
    }

}