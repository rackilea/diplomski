class Person {
    protected OnSadListener listener; // Make it protected or add accessor/mutators

    void setListener(OnSadListener listener) {
        this.listener = listener;
    }
}