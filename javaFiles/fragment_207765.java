public class AllTestSuite extends TestSuite{

  public static Test suite() {
      TestSuite suite= new TestSuite();
      Test testCase1 = new MyTest("TestCaseOne");
      Test testCase2 = new MyTest("TestCaseTwo");
      suite.addTest(testCase1);
      suite.addTest(testCase2);
      return suite;
  }
}