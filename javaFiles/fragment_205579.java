doAnswer(new Answer<Integer>() {
  public Object answer(InvocationOnMock invocation) {
      Object[] args = invocation.getArguments();
      int i = (int)args[0];
      return i * CONSTANT;
  }
}).when(dep.doMath(any(Integer.class));