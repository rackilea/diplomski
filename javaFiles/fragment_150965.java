public class MyObservableClass {

    List<SimpleObserver> observers = new ArrayList<SimpleObserver>();

    /**
     * Registers the observer
     */
    public void addObserver(SimpleObserver observer) {
        observers.add(observer);
    }

    /**
     * Removes the registered observer (to be nice towards the
     * garbage collector).
     */
    public void removeObserver(SimpleObserver observer) {
        observers.remove(observer);
    }

    /**
     * Notifies the observers with the given data
     */
    private void notifyObservers(String data) {
        for(SimpleObserver o : observers) {
            o.onEvent(data);
        }
    }

    public void doSomething() {
        // Do some stuff
        String data = "Waffles and pwnies";
        // Notify the observers that something happened.
        notifyObservers(data)
    }

}