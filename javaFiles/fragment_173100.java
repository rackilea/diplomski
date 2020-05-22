public class ReflectiveMockAnswer implements Answer<Object> {
  @Override public Object answer(InvocationOnMock invocation) {
    // Assume you've successfully parsed each String into a StubbedResponse, with
    // Object target, String method, String[] argTypes, and Object returnValue.
    // A Set would beat a for-loop here, should you need to optimize.
    for (StubbedResponse stubbedResponse : allStubbedResponses) {
      if (stubbedResponse.target == invocation.getMock()
          && stubbedResponse.method.equals(invocation.getMethod().getName())
          && stringArraysEqual(stubbedResponse.argTypes,
              typeNamesFrom(invocation.getMethod().getParameterTypes())) {
        return stubbedResponse.returnValue;
      }
    }
    throw new RuntimeException("Unstubbed method called.");
  }
}

// Later...
Object yourMockObject = Mockito.mock(classToMock, new ReflectiveMockAnswer());