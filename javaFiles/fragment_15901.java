private List<Observer> observers = new ArrayList<Observer>();

public void addObserver(Observer observer) {
    if (!observers.contains(observer)) {
         observers.add(observer);
    }
}

public void removeObserver(Observer observer) {
    observers.remove(observer);
}

protected fireNotification(Object notification) {
    for(Observer observer:observers) {
        observer.update(notification, this);
    }
}