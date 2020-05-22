public static Object getOuterInstance(Object inner)
        throws NoSuchFieldException, SecurityException,
        IllegalArgumentException, IllegalAccessException {

    Class<?> clazz = inner.getClass();
    Field f = clazz.getDeclaredField("this$0");
    f.setAccessible(true);//in case of class placed in different package

    return f.get(inner);
}