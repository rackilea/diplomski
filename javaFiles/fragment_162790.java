new Answer() {
  public Object answer(InvocationOnMock invocation) {
      Object[] args = invocation.getArguments();
      Mock mock = invocation.getMock();
      return null;
  }}