public class YourClassTest {
  private YourClass stubYourClass() {
    YourClass yourClass = Mockito.mock(YourClass.test, Mockito.CALLS_REAL_METHODS);
    doNothing().when(yourClass).addInfoMessage(anyString());
    doNothing().when(yourClass).addErrorMessage(anyString());
    doNothing().when(yourClass).saveAccountInternal();
    return yourClass;
  }

  @Test public void closeTransactionShouldSave() {
    YourClass yourClass = stubYourClass();
    assertNull(yourClass.closeTransaction());
    verify(yourClass).saveAccountInternal();
    verify(yourClass).addInfoMessage(anyString());
    verify(yourClass, never()).addErrorMessage(anyString());
  }

  @Test public void closeTransactionShouldSave() {
    YourClass yourClass = stubYourClass();
    doThrow(new ResourceException()).when(yourClass).saveAccountInternal();
    assertNull(yourClass.closeTransaction());
    verify(yourClass).saveAccountInternal();
    verify(yourClass).addErrorMessage(anyString());
    verify(yourClass, never()).addInfoMessage(anyString());
  }
}