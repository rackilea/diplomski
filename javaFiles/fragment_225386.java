Mockito.when(client.get(Mockito.any(Request.class)))
 .thenAnswer(new Answer() {
   Object answer(InvocationOnMock invocation) {
     Object[] args = invocation.getArguments();
     Object mock = invocation.getMock();
     return "called with arguments: " + args;
   }
});