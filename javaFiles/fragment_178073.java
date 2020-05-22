private ObjectProperty<EventHandler<Event>> onShown = new ObjectPropertyBase<EventHandler<Event>>() {
    @Override protected void invalidated() {
        setEventHandler(ON_SHOWN, get());
    }

    ....
};