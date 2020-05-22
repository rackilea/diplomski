class Baby extends Person {
    OnCryingListener listener;

    @Override
    void setListener(OnSadListener listener) {
        this.listener = (OnCryingListener) listener;
    }

    void cry() {
        listener.imSad();
        listener.imCrying();
    }
}