public abstract DroneEventAdapter implements DroneEventListener {
    @Override
    public void temperatureMeasured(EventObject event) {}

    @Override
    public void pressureMeasured(EventObject event) {}

    @Override
    public void disconnectEvent(EventObject event) {}

    @Override
    public void connectEvent(EventObject event) {}

    // Etc.
}