class C extends A<String> {
    private final B delegate;  // Set up in constructor or whatever

    public void foo(String input) {
        //.. convert int to string
        delegate.foo(Integer.valueof(input));
    }
}