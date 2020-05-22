@Test
public void nullArgument() {
    when(mockedClass.getValues()).thenReturn(null);
    Assert.assertTrue(TestedClass.getBoolean(mockedClass));
}
@Test
public void emptyListArgument() {
    List<String> emptyList = Collections.<String>emptyList();
    when(mockedClass.getValues()).thenReturn(emptyList);
    Assert.assertTrue(TestedClass.getBoolean(mockedClass));
}