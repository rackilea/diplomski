abstract class EventListener<T> {
    private Class<T> type;
    EventListener(Class<T> type) {
        this.type = type;
    }
    Class<T> getType() {
        return type;
    }

    abstract void onEvent(T t);
}