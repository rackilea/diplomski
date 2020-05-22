@Test
public void testExample() throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException, NoSuchFieldException {
    Constructor<Example> exampleConstructor = Example.class.getDeclaredConstructor(String.class, String.class);
    exampleConstructor.setAccessible(true);
    Example example = exampleConstructor.newInstance("foo", "bar");

    // verify
    Field str1 = example.getClass().getDeclaredField("str1");
    Field str2 = example.getClass().getDeclaredField("str2");
    str1.setAccessible(true);
    str2.setAccessible(true);

    assertThat("foo", equalTo(str1.get(example)));
    assertThat("bar", equalTo(str2.get(example)));
}