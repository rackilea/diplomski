@Category(UnitTest.class)
@RunWith(MockitoJUnitRunner.class)
public class ConstructorInjectionBug {

  @Mock
  private IBroken aBroken;

  @Mock
  private IBroken bBroken;

  private UsesBroken usesBroken;

  @Test
  public void testBrokenConstructorInjection() {
    //Arrange
    usesBroken = new UsesBroken(aBroken, bBroken);
    when(bBroken.getNumber()).thenReturn(2);
    when(aBroken.getNumber()).thenReturn(1);

    //Act & Assert
    assertEquals(2, usesBroken.getbBroken().getNumber());    
    assertEquals(1, usesBroken.getaBroken().getNumber());
  }
}