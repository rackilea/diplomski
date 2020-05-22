public void someMethodInB() {
    // change happened
    if (listener != null) {
        listener.onChangeHappened();
    }
}