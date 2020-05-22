class EnumResolver {

    private Map<String, Enum> map = new ConcurrentHashMap<>();

    public EnumResolver(String className) {
        try {
            Class enumClass = Class.forName(className);

            // look for backing property field, e.g. "sign" in SignalEnum
            Field accessor = Arrays.stream(enumClass.getDeclaredFields())
                    .filter(f -> f.getType().equals(String.class))
                    .findFirst()
                    .orElseThrow(() -> new NoSuchFieldException("Not found field to access enum backing value"));

            accessor.setAccessible(true);

            // populate map with pairs like ["1" => SignalEnum.RED, "2" => SignalEnum.GREEN, etc]
            for (Enum e : getEnumValues(enumClass)) {
                map.put((String) accessor.get(e), e);
            }

            accessor.setAccessible(false);
        } catch (ReflectiveOperationException e) {
            throw new RuntimeException(e);
        }
    }

    public Enum resolve(String backingValue) {
        return map.get(backingValue);
    }

    private <E extends Enum> E[] getEnumValues(Class<E> enumClass) throws ReflectiveOperationException {
        Field f = enumClass.getDeclaredField("$VALUES");
        f.setAccessible(true);
        Object o = f.get(null);
        f.setAccessible(false);
        return (E[]) o;
    }
}