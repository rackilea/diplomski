public static <E extends Enum<E>> E getEnum(Class<E> enumClass) {
    String valueString = // get it somehow
    try {
        return Enum.valueOf(enumClass, valueString);
    } catch (Exception e) {
        return null;
    }
}