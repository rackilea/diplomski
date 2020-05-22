doAnswer(new Answer<String>() {
  @Override public void answer(InvocationOnMock invocation) {
    // This field on the test changes based on other invocations.
    return currentAlphabet;
  }
}).when(dummyObj).innerMethod(anyInt(), anyInt());