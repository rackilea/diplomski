public static <T> T deserializeEnumeration(Class<? extends T> type, InputStream inputStream){
    try {
        int asInt = deserializeInt(inputStream);
        // int.class indicates the parameter
        Method method = type.getDeclaredMethod("getAsInt", int.class);
        // null means no instance as it is a static method
        return method.invoke(null, asInt);
    } catch(NoSuchMethodException, InvocationTargetException, IllegalAccessException e){
       throw new IllegalStateException(e);
    }
}