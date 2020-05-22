import junit.framework.Test;
import junit.framework.TestSuite;

public class EcommerceTestSuite {

    public static Test suite() {

        TestSuite suite = new TestSuite();

        //
        // The ShoppingCartTest we created above.
        //
        suite.addTestSuite(ShoppingCartTest.class);

        //
        // Another example test suite of tests.
        // 
        suite.addTest(CreditCardTestSuite.suite());

        //
        // Add more tests here
        //

        return suite;
    }

    /**
     * Runs the test suite using the textual runner.
     */
    public static void main(String[] args) {
        junit.textui.TestRunner.run(suite());
    }
}