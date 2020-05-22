foo = createFoo();

...


private static Foo createFoo() {
    try {
        return new Foo();
    } catch (Exception e) {
        e.printStackTrace();
        return null;
    }
}