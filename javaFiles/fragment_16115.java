public void testMyFunction() throws Exception {
  Application mock = mock(Application.class);
  when(mock.myFunction(anyString())).thenAnswer(new Answer<String>() {
    @Override
    public String answer(InvocationOnMock invocation) throws Throwable {
      Object[] args = invocation.getArguments();
      return (String) args[0];
    }
  });

  assertEquals("someString",mock.myFunction("someString"));
  assertEquals("anotherString",mock.myFunction("anotherString"));
}