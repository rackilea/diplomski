public final class PojoValidator() {
    private PojoValidator() {
        // Pure utility class, do NOT instantiate.
    }

    public static String validateFoo(final String foo) {
        // Validate the provided foo here.
        // Validation logic can throw:
        // - checked exceptions if you can/want to recover from an invalid foo, 
        // - unchecked exceptions if you consider these as runtime exceptions and can't really recover (less clutering of your API).
        return foo;
    }

    public static Bar validateBar(final Bar bar) {
        // Same as above...
        // Can itself call other validators.
        return bar;
    }
}