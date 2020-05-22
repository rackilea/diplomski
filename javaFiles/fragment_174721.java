void b(final Class<?> type, final Object instance) {

    if (!type.isInstance(instance)) {
        // throw exception
    }

    bHelper(type, instance);
}

private <T> void bHelper(final Class<T> type, final Object instance) {
    final T t = type.cast(instance);
    a(type, t);
}