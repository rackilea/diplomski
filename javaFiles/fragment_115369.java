public static Object parse(String value, Class<?> clazz) throws NotSupportedException {
    String canonClassName = clazz.getCanonicalName();

    if (canonClassName.equalsIgnoreCase("java.math.BigDecimal")) {
        return new BigDecimal(value);
    }

    // Add other supported classes here ...

    throw new NotSupportedException("The class [" + canonClassName  + "] is not supported.");
}