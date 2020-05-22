enum Foo {
    PEAR,
    BANANA() {
        @Override
        public void doFoo() {
            System.out.println("Banana foo");
        }
    },
    APPLE,
    GRAPE;

    public void doFoo() {
        System.out.println("Default foo");
    }
}