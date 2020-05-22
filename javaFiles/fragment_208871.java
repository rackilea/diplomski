class Example {
    private static WeakHashMap<Example, Data> details = new WeakHashMap<>();

    private static class Data {
        // ...private information...
    }

    public Example() {
        Data d = new Data();
        details.set(this, d);
    }

    public void doSomething() {
        Data d = details.get(this);
        if (d == null) {
            throw new IllegalStateException();
        }
        // ...do something...
    }
}