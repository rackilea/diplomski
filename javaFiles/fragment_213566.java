public static <T extends Enum<T> & HasVal> getEnumFromVal(Class<T> enumClass, String val) {
    for (T e : enumClass.getEnumConstants()) {
        if (e.getVal().equals(val)) {
            return e;
        }
    }
    return null;
}