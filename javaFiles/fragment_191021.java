public class Person <T extends OnSadListener> {
    protected T listener;

    public void setListener(T listener) {
        this.listener = listener;
    }
}