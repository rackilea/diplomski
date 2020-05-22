private void copyIfSpecified(final Car from, final NewObject to, final String propName)
        throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
    final Object value = PropertyUtils.getSimpleProperty(from, propName);
    if (value != null) {
        PropertyUtils.setSimpleProperty(to, propName, value);
    }
}