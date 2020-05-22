enum ConnectionHelper {
    INSTANCE;
    private final int someVar;
    ConnectionHelper() {
        someVar = 10; // as place-holder for more complex initialization
    }
    void start() {
    // do some work, use the already initialized someVar...
    }
}