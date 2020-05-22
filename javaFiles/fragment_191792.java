public class YourClassTest {
  private static class TestYourClass extends YourClass {
    boolean saveCalled = false;
    boolean shouldThrow = false;
    List<String> infoMessages = new ArrayList<>();
    List<String> errorMessages = new ArrayList<>();
    protected void addInfoMessage(String message) { infoMessages.add(message); }
    protected void addErrorMessage(String message) { errorMessages.add(message); }

    @Override void saveAccountInternal() throws ResourceException {
      saveCalled = true;
      if (shouldThrow) throw new ResourceException();
    }
  }

  @Test public void closeTransactionShouldSave() {
    TestYourClass testYourClass = new TestYourClass();
    assertNull(testYourClass.closeTransaction());
    assertTrue(testYourClass.saveCalled);
    assertEquals(1, testYourClass.infoMessages.size());
    assertEquals(0, testYourClass.errorMessages.size());
  }

  @Test public void closeTransactionShouldSave() {
    TestYourClass testYourClass = new TestYourClass();
    testYourClass.shouldThrow = true;
    assertNull(testYourClass.closeTransaction());
    assertTrue(testYourClass.saveCalled);
    assertEquals(1, testYourClass.infoMessages.size());
    assertEquals(0, testYourClass.errorMessages.size());
  }
}