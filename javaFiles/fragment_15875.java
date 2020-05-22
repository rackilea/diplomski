private static boolean isAssignable(TypeToken<?> resolved, Class<?> implClass) {
    return resolved.isSupertypeOf(implClass) || isAnySupertypeAssignable(resolved, implClass);
}

private static boolean isAnySupertypeAssignable(TypeToken<?> resolved, Class<?> implClass) {
    return TypeToken.of(implClass).getTypes().stream()
            .anyMatch(supertype -> isUncheckedSupertype(resolved, supertype));
}

private static boolean isUncheckedSupertype(TypeToken<?> resolved, TypeToken<?> implTypeToken) {
    if (implTypeToken.getType() instanceof ParameterizedType) {
        return false; // this prevents assignments of Collection<Integer> to Collection<Timestamp>
    }
    try {
        resolved.getSubtype(implTypeToken.getRawType());
        return true;
    } catch (IllegalArgumentException ex) {
        return false;
    }
}