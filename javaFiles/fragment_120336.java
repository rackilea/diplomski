@Test
public void thingShouldDoX() throws Exception {
  Policy.applyAll();
  // Do setup here, everything inside will be consistent.
  Policy.applyNone();
  // Run code under test here, without consistency.
}