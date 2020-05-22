class EnumFromInt {

    private static final Map<Class<?>, Object[]> _values = new HashMap<>();

    @SuppressWarnings("unchecked")
    private static <TEnum extends Enum<TEnum>> TEnum[] getValues(Class<TEnum> cls) {
        return (TEnum[]) _values.computeIfAbsent(cls, Class::getEnumConstants);
    }
}