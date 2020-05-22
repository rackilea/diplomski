@Test
public void when_gambling_is_true_then_always_explode() throws Exception {
  // Spy CodeWithAnotherPrivateMethod and force return true when doTheGamble is called
  CodeWithAnotherPrivateMethod codeWithAnotherPrivateMethod = PowerMockito.spy(new CodeWithAnotherPrivateMethod());
  PowerMockito.doReturn(true).when(codeWithAnotherPrivateMethod, "doTheGamble", Mockito.anyString(), Mockito.anyInt());
  // Return your mock when a new instance of CodeWithAnotherPrivateMethod is created.
  PowerMockito.whenNew(CodeWithAnotherPrivateMethod.class).withAnyArguments().thenReturn(codeWithAnotherPrivateMethod);

  CodeWithPrivateMethod spy = PowerMockito.spy(new CodeWithPrivateMethod());
  spy.meaningfulPublicApi();
}