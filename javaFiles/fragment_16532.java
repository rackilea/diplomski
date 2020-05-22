public abstract DroneEventAdapter implements DroneEventListener {
    public abstract void eventOccured(EventObject event);

    @Override
    public void temperatureMeasured(EventObject event) {
        eventOccured(event);
    }

    @Override
    public void pressureMeasured(EventObject event) {
        eventOccured(event);
    }

    @Override
    public void disconnectEvent(EventObject event) {
        eventOccured(event);
    }

    @Override
    public void connectEvent(EventObject event) {
        eventOccured(event);
    }

    // Etc.
}