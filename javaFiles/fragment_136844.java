@Test
public void test() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
   Method privateMethod = ReflectionUtils.findRequiredMethod(MyService.class, "privateMethod", int.class, int.class);
    int res = (int) privateMethod.invoke(service, 5, 10);
    assertEquals(5 + 10, res);
}