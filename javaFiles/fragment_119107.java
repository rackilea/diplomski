public class Connect extends Observable {

    Connection conn;

    public Connect(Observer o) {
        addObserver(o);
    }

    public void getConnection() {
        // TODO getConnection
        hasChanged();
        notifyObservers();
    }

    public void closeConnection() {
        // TODO closeConnection
        hasChanged();
        notifyObservers();
    }
}