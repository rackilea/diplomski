@RunWith(AllTests.class)
public final class MyTestSuite extends MyTestBase{
    public static TestSuite suite() {               
        TestSuite suite = new TestSuite();
        for (Test test : findAllTestCasesRuntime()) { // returns a list of JUnit4TestAdapter(Class.forName(fileName))
          suite.addTest(test);
        }    
        return suite;
      }
}