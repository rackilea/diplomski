@Test
public void testProcess2(){
    Context context = Mockito.mock(Context.class);
    Mockito.when(context.getState()).thenReturn(new TestState());
    context.getState().setValue(4.12345);
    sample.process(context);
    assertEquals(4.123,context.getState().getValue(),0.0);
}