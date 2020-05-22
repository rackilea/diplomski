class Foo {
    private Object lock = new Object();

    public void doSomething() {
        sychronized(lock) {
            ...
        }
    }
}