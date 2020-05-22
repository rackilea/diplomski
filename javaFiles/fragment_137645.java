String currentAlphabet;

 private ruleSetUp() {
   // [snip]
   Mockito.doReturn(currentAlphabet).when(dummyObj).innerMethod(
       Mockito.anyInt(), Mockito.anyInt());
 }