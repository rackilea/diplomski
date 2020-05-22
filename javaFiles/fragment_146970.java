public static void main(String[] args) {
    String s = "java.lang.String";

    Object o = "Some Value";

    Class<?> type;
    try {
        type = Class.forName(s);
        getValue(type, o);
    } catch (ClassNotFoundException e) {
        // class was not found
        e.printStackTrace();
    }
}

private static <T> T getValue(Class<T> desiredType, Object o) {
    if (o.getClass().isAssignableFrom(desiredType)) {
        return desiredType.cast(o);
    } else {
        throw new IllegalArgumentException();
    }

}