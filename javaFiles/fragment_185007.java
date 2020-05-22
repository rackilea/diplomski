public static <T> T handleExceptions(Supplier<T> r, T defaultValue) {
    try {
        return r.get();
    }
    catch(RuntimeException ex) {
        ex.printStackTrace();
        return defaultValue;
    }
}