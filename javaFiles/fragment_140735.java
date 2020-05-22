public static <I, O> O cast(I input, Class<O> outClass) {
    try {
        return outClass.cast(input);
    } catch (ClassCastException e) {
        return null;
    }
}