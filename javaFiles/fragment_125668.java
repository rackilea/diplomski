class Foo {
    private static doSomething() {
        synchronized(Foo.class) {
            // Synchronized code
        }
    }
}