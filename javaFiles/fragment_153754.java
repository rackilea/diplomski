public static int parse(String input) {
    Field[] fields = KeyInput.class.getDeclaredFields();

    for (Field field : fields) {
        if (Modifier.isStatic(fields.getModifiers()) && field.getDeclaringClass().equals(int.class) && field.getName().equals(input)) {
            return field.getInt(null);
        }
    }

    throw new IllegalArgumentException("unknown string");
}