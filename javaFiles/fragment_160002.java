EventBus bus = new SimpleEventBus();

@Override
public void fireEvent(GwtEvent<?> event) {
    bus.fireEvent(event);
}

@Override
public HandlerRegistration addValueChangeHandler(ValueChangeHandler<T> handler) {
    return bus.addHandler(ValueChangeEvent.getType(), handler);
}