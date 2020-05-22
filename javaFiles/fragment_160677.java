public static <T> T initializeAndUnproxy(T var) {
    if (var == null) {
        throw new IllegalArgumentException("passed argument is null");
    }

    Hibernate.initialize(var);
    if (var instanceof HibernateProxy) {
        var = (T) ((HibernateProxy) var).getHibernateLazyInitializer()
                .getImplementation();
    }
    return var;
}