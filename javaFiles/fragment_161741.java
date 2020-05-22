public void method(String parameterName) {
    try {
        // We can get the current field value:
        int value = (int) getClass().getField(parameterName).get(this);

        // And update it (for example, set it to 23)
        getClass().getField(parameterName).set(this, 23);
    catch (NoSuchFieldException | IllegalAccessException ex) {
        // Field does not exist or is not public.
    }
}