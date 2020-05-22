@Test
  public void test_that_yeepee_works() {
    final Yeepee y = Mockito.mock(Yeepee.class);    
    Assertions.assertNotNull(y.myObject); // fails.
  }

  public static class Yeepee {
    public Object myObject = new Object();
  }