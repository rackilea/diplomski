class Thing {
    private int bar = 16; // An initializer on the declaration
    private int foo;

    // An instance initializer block
    {
        this.foo = 42; // Or just foo = 42;, but I prefer to be clear
    }
}