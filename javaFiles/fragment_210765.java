private static Object newInstance(String className) throws ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchMethodException, IllegalArgumentException, InvocationTargetException
{
    return newInstance(className, new Class<?>[0], new Object[0]);
}

private static Object newInstance(String className, Class<?>[] parameterClasses, Object[] parameterValues) throws NoSuchMethodException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, ClassNotFoundException
{
    Class<?> clz = Class.forName(className);
    Constructor<?> constructor = clz.getConstructor(parameterClasses);
    return constructor.newInstance(parameterValues);
}

@SuppressWarnings({ "unchecked", "rawtypes" })
private static Object getEnumValue(String enumClassName, String enumValue) throws ClassNotFoundException
{
    Class<Enum> enumClz = (Class<Enum>)Class.forName(enumClassName);
    return Enum.valueOf(enumClz, enumValue);
}

private static void setField(Object object, String fieldName, Object value) throws IllegalAccessException, IllegalArgumentException, NoSuchFieldException
{
    Field field = object.getClass().getDeclaredField(fieldName);
    field.set(object, value);
}

private static <T> T getField(Object object, String fieldName, Class<T> type) throws IllegalAccessException, IllegalArgumentException, NoSuchFieldException
{
    Field field = object.getClass().getDeclaredField(fieldName);
    return type.cast(field.get(object));
}

private static void callMethod(Object object, String methodName, String[] parameterTypes, Object[] parameterValues) throws ClassNotFoundException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException
{
    Class<?>[] parameterClasses = new Class<?>[parameterTypes.length];
    for (int i = 0; i < parameterTypes.length; i++)
        parameterClasses[i] = Class.forName(parameterTypes[i]);

    Method method = object.getClass().getDeclaredMethod(methodName, parameterClasses);
    method.invoke(object, parameterValues);
}