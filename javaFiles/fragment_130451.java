f(new Callback() {
    public void doCallback() {
        f1();
    }
});
f(new Callback() {
    public void doCallback() {
        f2();
    }
});