public static <I, O> O cast(I input, Class<O> outClass) {
    if(outClass.isAssignableFrom(input.getClass())) {
        return outClass.cast(input); 
    } else {
        return null;
    }
}