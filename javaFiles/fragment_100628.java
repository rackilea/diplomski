protected <T extends MyModelBaseClass> T getModelExample(Class<T> clazz) {
    try {
        T result = clazz.newInstance();
        for(Field field  : clazz.getDeclaredFields()) {
            if (field.isAnnotationPresent(ApiModelProperty.class)) {
                String exampleValue = field.getAnnotation(ApiModelProperty.class).example();
                if (exampleValue != null) {
                    boolean accessible = field.isAccessible();
                    field.setAccessible(true);
                    setField(result, field, exampleValue);
                    field.setAccessible(accessible);
                }
            }
        }
        return result;
    } catch (InstantiationException | IllegalAccessException e) {
        throw new IllegalArgumentException("Could not create model example", e);
    }
}

private <T extends MyModelBaseClass> void setField(T model, Field field, String value) throws IllegalArgumentException, IllegalAccessException {
    Class<?> type = field.getType();
    LOGGER.info(type.toString());
    if (String.class.equals(type)) {
        field.set(model, value);
    } else if (Boolean.TYPE.equals(type) || Boolean.class.equals(type)) {
        field.set(model, Boolean.parseBoolean(value));
    } else if (Integer.TYPE.equals(type) || Integer.class.equals(type)) {
        field.set(model, Integer.parseInt(value));
    }
}