import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({
  // Add a JUnit 3 suite
  CalculatorSuite.class,
  // JUnit 4 style tests
  TestCalculatorAddition.class,
  TestCalculatorDivision.class
})
public class CalculatorSuite {
    // A traditional JUnit 3 suite
    public static Test suite() {
        TestSuite suite = new TestSuite();
        suite.addTestSuite(TestCalculatorSubtraction.class);
        return suite;
    }
}