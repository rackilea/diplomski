@Test
public void testEnumOne() throws Exception {
   Method methodOne = MockClass.class.getDeclaredMethod("enumOne");
   Mockito.when(resourceInfo.getResourceMethod()).thenReturn(methodOne);
}

private static class MockClass {
    @MyAnnotation(info=MyEnum.VALUE1)
    public void enumOne() {}
    @MyAnnotation(info=MyEnum.VALUE2)
    public void enumTwo() {}
}