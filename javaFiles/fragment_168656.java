class ParameterizedClass<T> {
    private Class<T> type;

    /** Factory method */
    public static <T> ParameterizedClass<T> of(Class<T> type) {
        return new ParameterizedClass<T>(type);
    }

    /** Private constructor; use the factory method instead */
    private ParameterizedClass(Class<T> type) {
        this.type = type;
    }

    // Do something useful with type
}