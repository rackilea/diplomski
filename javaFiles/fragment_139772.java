public class Serial implements Runnable {
    private final List<MListener> observers = new CopyOnWriteArrayList<>();
    ...
    public void notifyListeners(CS value) {
        log.debug("notifying listeners with Control ");
        for (MListener observer : observers) {
            observer.dataReceived(value);
        }
    }