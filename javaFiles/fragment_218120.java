private boolean isSimpleType(Class<?> type) {
    return type.isPrimitive() ||
            Boolean.class == type ||
            Character.class == type ||
            CharSequence.class.isAssignableFrom(type) ||
            Number.class.isAssignableFrom(type) ||
            Enum.class.isAssignableFrom(type);
}