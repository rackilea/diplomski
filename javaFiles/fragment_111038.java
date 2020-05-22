class Example<T> {

    public <T> void foo1() {
        // T here is the <T> declared on foo1
    }

    public void foo2() {
        // T here is the <T> declared on the class Example
    }
}