notifyMessageListeners(message, new ValueGetter<T>() {
    public T getValue(String data) {
        return (T) Notification.valueOf(data);
    }
});

notifyMessageListeners(message, new ValueGetter<T>() {
    public T getValue(String data) {
        return (T) Integer.valueOf(data);
    }
});