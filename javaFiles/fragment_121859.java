// field with updated value on the javafx application thread
private T value;

public AsyncBinding(ObservableValue<T> original) {
    super();
    this.original = original;
    changeListener = (obs, oldValue, newValue) -> {
        Runnable job = () -> {
            value = newValue; // make sure the value on the application thread is the new value
            for (InvalidationListener listener : invalidationListeners) {
                listener.invalidated(obs);
            }
            for (ChangeListener<? super T> listener : changeListeners) {
                listener.changed(obs, oldValue, newValue);
            }
        };
        Platform.runLater(job);
    };
    original.addListener(changeListener);
}

...

@Override
public T getValue() {
    return value;
}