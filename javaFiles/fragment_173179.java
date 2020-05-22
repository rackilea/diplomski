public static Test suite() {
  return new TestSetup(new TestSuite(YourTestClass.class)) {

    protected void setUp() throws Exception {
        System.out.println(" Global setUp ");
    }
    protected void tearDown() throws Exception {
        System.out.println(" Global tearDown ");
    }
  };
}