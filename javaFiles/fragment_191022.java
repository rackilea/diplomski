public class Baby extends Person<OnCryingListener> {
    @Override
    public void setListener(OnCryingListener listener) {
        this.listener = (OnCryingListener) listener;
    }

    public void cry() {
        listener.imSad();
        listener.imCrying(); // No need to cast
    }
}