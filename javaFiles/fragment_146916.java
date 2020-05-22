private Object callGet(final String fieldName) throws NoSuchMethodException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
    final Method method = getClass().getDeclaredMethod("get" + fieldName.substring(0, 1).toUpperCase() + fieldName.substring(1));
    return method.invoke(this, (Object[]) null);
}

private void callSet(final String fieldName, final Object valueToSet) throws NoSuchMethodException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
    final Method method = getClass().getDeclaredMethod("set" + fieldName.substring(0, 1).toUpperCase() + fieldName.substring(1), new Class[]{valueToSet.getClass()});
    method.invoke(this, new Object[]{valueToSet});
}