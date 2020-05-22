@Test
public void invoke() throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
    Method method = ReflectTest.class.getMethod("setO", int.class);
    method.invoke(new ReflectTest(), 3);
    method.invoke(new ReflectTest(), Integer.valueOf(3));

    method = ReflectTest.class.getMethod("setO", Integer.class);
    method.invoke(new ReflectTest(), 3);
    method.invoke(new ReflectTest(), Integer.valueOf(3));
}