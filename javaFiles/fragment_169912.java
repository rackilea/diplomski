enum Foo {
    A("foo", "bar"),
    B(0, 1, 2);
    private Stack<?> stack;
    private <T> Foo(T... args) {
        stack = new Stack<T>();
        stack.addAll(Arrays.asList(args));
    }
    public <T> Stack<T> getStack() {
        return (Stack<T>) stack;
    }
}