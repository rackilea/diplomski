enum Singleton {
    INSTANCE;

    private Field field = VALUE;
    public Value method(Arg arg) { /* some code */ }
}

// You can use
Value v = Singleton.INSTANCE.method(arg);