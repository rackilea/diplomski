@Test
public void methodTest() {
    ClassToTest objectToTest = PowerMockito.spy(new ClassToTest());
    try {
        when(objectToTest, method(ClassToTest.class, "privateMethod", boolean.class)).withArguments(false).thenReturn(mockAsyncTask);
    } catch (Exception e) {
        e.printStackTrace();
    }
}