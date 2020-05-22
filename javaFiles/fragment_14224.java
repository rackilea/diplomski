public class ExceptionWithPayload<T> extends Exception {
    private final T payload;
    public ExceptionWithPayload(T payload) {
        this.payload = payload;
    }
    public T getPayload(){
        return payload;
    }
}