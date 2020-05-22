public static <T> Consumer<T> toConsumer(Object annotated, Method m) {
    return param -> {
        try {
            m.invoke(annotated, param);
        } catch (IllegalAccessException | InvocationTargetException e) {
            throw new RuntimeException(e);
        }
    };
}