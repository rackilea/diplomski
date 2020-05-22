public class SLF4JTypeListener implements TypeListener {

    public <T> void hear(TypeLiteral<T> typeLiteral,
            TypeEncounter<T> typeEncounter) {

        // the class which members will be injected
        Class<?> clazz = typeLiteral.getRawType();

        while (clazz != null) {
            //add listener for any field
            Arrays.stream(clazz.getDeclaredFields())
                    .filter(this::isLoggerField)
                    .forEach(
                            f -> typeEncounter
                                    .register(new SLF4JMembersInjector<T>(f)));
            clazz = clazz.getSuperclass();
        }
    }

    private boolean isLoggerField(Field f) {
        return f.getType() == Logger.class
                && f.isAnnotationPresent(InjectLogger.class);
    }
}