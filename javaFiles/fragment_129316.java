public final class System {
    ...
    public static void load(String filename) {
        Runtime.getRuntime().load0(getCallerClass(), filename);
    }
    ...
}