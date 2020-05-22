class Baby extends Person {
    @Override
    void setListener(OnSadListener listener) {
        this.listener = (OnCryingListener) listener;
    }

    void cry() {
        listener.imSad();
        ((OnCryingListener) listener).imCrying(); // Cast here
    }
}