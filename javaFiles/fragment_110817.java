@RunWith(MockitoJUnitRunner.class)
class ActivityTest() {

  @Spy
  Activity act = new Activity();

  @Test
  public void testFirstMethod(){

      Mockito.doReturn("someString").when(act).secondMethod();
      act.firstMethod();
      verify(act).secondMethod();
  }
}