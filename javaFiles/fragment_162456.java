@Test
public void startTest() throws Exception {
    new ThreadedTestRunner().runTests(getClass(), Example.class);
}

@ThreadedTest
public void testThreadWeaver() throws Exception {
  // here comes your test
}