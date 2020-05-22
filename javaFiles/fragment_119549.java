class Test {
    private static final int a;
    private static int b;
    private final int c;
    private int c;

    // runs once the class is loaded
    static {
        a = 0;
        b = 0;
        c = 0;  // error: non-static variables c and d cannot be
        d = 0;  // referenced from a static context
    }

    // instance block, runs every time an instance is created
    {
        a = 0;  // error: static and final cannot be initialized here
        b = 0;
        c = 0;
        d = 0;
    }
}