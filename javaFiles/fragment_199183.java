public static Optional<String> colorName(Color c) {
    for (Field f : Color.class.getDeclaredFields()) {
        //we want to test only fields of type Color
        if (f.getType().equals(Color.class))
            try {
                if (f.get(null).equals(c))
                    return Optional.of(f.getName().toLowerCase());
            } catch (IllegalArgumentException | IllegalAccessException e) {
                // shouldn't not be thrown, but just in case print its stacktrace
                e.printStackTrace();
            }
    }
    return Optional.empty();
}