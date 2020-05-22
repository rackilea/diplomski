interface Foo {
    static class FooLoader {
        private static Object init() {
            System.out.printf("Initializing %s%n", Foo.class);
        }
    }

    Object NULL = FooLoader.init();
}