when(mock.load("a")).thenAnswer(new Answer<String>() {
   @Override
   public String answer(InvocationOnMock invocation){
     Thread.sleep(5000);
     return "ABCD1234";
   }
});