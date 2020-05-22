@Test
public void testDefaultHandlerIsSet() {
   // creating a new instance should update the handler!
   new ClassThatThrowsException();
   Thread.UncaughtExceptionHandler handler = Thread.getDefaultUncaughtExceptionHandler();
   assertThat(handler, not(nullValue()));
   assertThat(handler, instanceOf(ExceptionHandler.class));
}