private final EventListenerList listenerList = new EventListenerList();
private final ChangeEvent stateChangeEvent = new ChangeEvent(this);

public void addChangeListener(ChangeListener l) {
    listenerList.add(ChangeListener.class, l);
}
public void removeChangeListener(ChangeListener l) {
    listenerList.remove(ChangeListener.class, l);
}
protected void fireChange() {
    for (ChangeListener l: listenerList.getListeners(ChangeListener.class)) {
        l.stateChanged(stateChangeEvent);
    }
}