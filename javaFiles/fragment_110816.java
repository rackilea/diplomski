class ActivityTest() {

  Activity act;

  @Before
  public void setup(){
     act = Mockito.spy(new Activity()); // Here!
  }

  @Test
  public void testFirstMethod(){

      Mockito.doReturn("someString").when(act).secondMethod();
      act.firstMethod();
      verify(act).secondMethod();
  }
}