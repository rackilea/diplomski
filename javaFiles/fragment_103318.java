@Test
public void invoke() throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
    invoke(new ReflectTest(), "setO", 3);
    invoke(new ReflectTest(), "setO", Integer.valueOf(3));
}

private void invoke(Object instance, String methodeName, Object argValue) throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
    System.out.println(argValue.getClass().isPrimitive());
    Method method = ReflectTest.class.getMethod("setO", argValue.getClass());
    method.invoke(new ReflectTest(), argValue);
    method.invoke(new ReflectTest(), Integer.valueOf(3));
}