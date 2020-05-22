class Client {
    private static String state;
    static {
        state = buildStateFromArgs(args);  // this value will not change
    }
}