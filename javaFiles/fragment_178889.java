@Test public void methodWithNumberOne {
  MyService myService = Mockito.mock(MyService.class);
  when(myService.getNumber()).thenReturn(1);

  // You might want to set MyService with a constructor argument, instead.
  SystemUnderTest systemUnderTest = new SystemUnderTest();
  systemUnderTest.myService = myService;

  systemUnderTest.method();
}